package com.bastex.codelearninghub.jakartaee.jms.basics.features;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.naming.InitialContext;
import java.io.Serial;
import java.io.Serializable;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JmsMessageFilteringTester {
    @SneakyThrows
    public static void testMessageFiltering() {
        final InitialContext context = new InitialContext();
        final Queue destinationQueue = (Queue) context.lookup("queue/myQueue");

        try (final ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
             final JMSContext jmsContext = connectionFactory.createContext()) {
            final JMSProducer producer = jmsContext.createProducer();

            sendTaskMessages(jmsContext, producer, destinationQueue);

            // Filter query specified when creating a consumer. Uses SQL like syntax with =, OR, AND, IN, BETWEEN etc.
            // It can also filter on JMS headers e.g. OR JMSPriority BETWEEN 3 AND 6
            final JMSConsumer processingTasksConsumer = jmsContext.createConsumer(destinationQueue, "taskType='PROCESSING'");
            processingTasksConsumer.setMessageListener(new TaskMessageListener("processingTaskConsumer"));

            final JMSConsumer pdfGenerationTaskConsumer = jmsContext.createConsumer(destinationQueue, "taskType='PDF_GENERATION'");
            pdfGenerationTaskConsumer.setMessageListener(new TaskMessageListener("pdfGenerationTaskConsumer"));

            Thread.currentThread().join();
        }
    }

    private static void sendTaskMessages(final JMSContext jmsContext, final JMSProducer producer, final Queue destinationQueue) throws JMSException {
        for (int i = 0; i < 5; i++) {
            final ObjectMessage pdfGenerationMessage = prepareTaskMessage(jmsContext, i, TaskType.PDF_GENERATION);
            producer.send(destinationQueue, pdfGenerationMessage);

            final ObjectMessage processingTaskMessage = prepareTaskMessage(jmsContext, i, TaskType.PROCESSING);
            producer.send(destinationQueue, processingTaskMessage);
        }
    }

    private static ObjectMessage prepareTaskMessage(final JMSContext jmsContext, final int taskId, final TaskType taskType) throws JMSException {
        final Task task = new Task(taskId, taskType);

        final ObjectMessage objectMessage = jmsContext.createObjectMessage();
        objectMessage.setObject(task);
        objectMessage.setStringProperty("taskType", taskType.name());

        return objectMessage;
    }

    public record Task(long id, TaskType taskType) implements Serializable {
        @Serial
        private static final long serialVersionUID = 1L;
    }

    public enum TaskType {
        PROCESSING, PDF_GENERATION
    }

    @RequiredArgsConstructor
    private static class TaskMessageListener implements MessageListener {
        private final String consumerName;

        @Override
        @SneakyThrows(JMSException.class)
        public void onMessage(final Message message) {
            final ObjectMessage objectMessage = (ObjectMessage) message;
            final Task task = objectMessage.getBody(Task.class);
            log.info("{} consumer consumed task id {} with type {}", consumerName, task.id(), objectMessage.getStringProperty("taskType"));
        }
    }
}
