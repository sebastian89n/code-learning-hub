package com.bastex.codelearninghub.jakartaee.jms.basics.features;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JmsMessageListenerTester {
    @SneakyThrows
    public static void testMessageListener() {
        final InitialContext context = new InitialContext();
        final Queue destinationQueue = (Queue) context.lookup("queue/myQueue");

        try (final ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
             final JMSContext jmsContext = connectionFactory.createContext()) {
            final JMSProducer producer = jmsContext.createProducer();
            for (int i = 0; i < 3; i++) {
                final TextMessage message = jmsContext.createTextMessage("Text message " + i);
                producer.send(destinationQueue, message);
            }

            final JMSConsumer consumer = jmsContext.createConsumer(destinationQueue);
            // sets asynchronous message listener in the consumer
            consumer.setMessageListener(new TaskMessageListener());

            Thread.currentThread().join();
        }
    }

    public static class TaskMessageListener implements MessageListener {
        @Override
        @SneakyThrows(JMSException.class)
        public void onMessage(final Message message) {
            if (message instanceof final TextMessage textMessage) {
                log.info("Received text message: {}", textMessage.getText());
            } else {
                log.warn("Unhandled message type. Ignoring...");
            }
        }
    }
}
