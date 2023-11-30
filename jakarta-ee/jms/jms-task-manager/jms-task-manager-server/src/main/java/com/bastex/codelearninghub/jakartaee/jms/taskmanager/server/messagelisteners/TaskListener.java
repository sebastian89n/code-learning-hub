package com.bastex.codelearninghub.jakartaee.jms.taskmanager.server.messagelisteners;

import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.TaskManagerCommonProperties;
import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.common.MessageWithUuid;
import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.tasks.requests.ScheduledTaskRequest;
import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.tasks.responses.TaskReply;
import com.bastex.codelearninghub.jakartaee.jms.taskmanager.server.processors.ScheduledTaskProcessor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

@Slf4j
public class TaskListener implements MessageListener {
    private final JMSContext jmsContext;

    private final JMSProducer producer;

    private final ScheduledTaskProcessor scheduledTaskProcessor;

    public TaskListener(final JMSContext jmsContext) {
        this.jmsContext = jmsContext;
        this.producer = jmsContext.createProducer();
        this.scheduledTaskProcessor = new ScheduledTaskProcessor();
    }

    @Override
    @SneakyThrows(JMSException.class)
    public void onMessage(final Message message) {
        final ObjectMessage taskObjectMessage = (ObjectMessage) message;

        final MessageWithUuid messageWithUuid = (MessageWithUuid) taskObjectMessage.getObject();
        log.info("Received task with uuid: {}", messageWithUuid.getUuid());

        final TaskReply taskReply = processTask(messageWithUuid);
        if (message.getJMSReplyTo() != null) {
            sendReplyForProcessedTask(message, taskObjectMessage, taskReply);
        } else {
            log.info("Task processed successfully");
        }

    }

    private TaskReply processTask(final MessageWithUuid messageWithUuid) {
        return switch (messageWithUuid) {
            case final ScheduledTaskRequest scheduledTask -> scheduledTaskProcessor.processTask(scheduledTask);
            default -> throw new IllegalStateException("Unhandled task type");
        };
    }

    private void sendReplyForProcessedTask(final Message message, final ObjectMessage taskObjectMessage, final TaskReply taskReply) throws JMSException {
        final String clientId = taskObjectMessage.getStringProperty(TaskManagerCommonProperties.TASK_MANAGER_CLIENT_ID);
        if (clientId != null && !clientId.isBlank()) {
            final ObjectMessage taskReplyObjectMessage = jmsContext.createObjectMessage();
            taskReplyObjectMessage.setStringProperty(TaskManagerCommonProperties.TASK_MANAGER_CLIENT_ID, clientId);
            producer.send(message.getJMSReplyTo(), taskReply);
            log.info("Task processed successfully. Reply sent for task uuid: {}", taskReply.getUuid());
        } else {
            log.warn("Ignoring task reply for task {}. {} was not provided.", taskReply.getUuid(),
                    TaskManagerCommonProperties.TASK_MANAGER_CLIENT_ID);
        }
    }
}
