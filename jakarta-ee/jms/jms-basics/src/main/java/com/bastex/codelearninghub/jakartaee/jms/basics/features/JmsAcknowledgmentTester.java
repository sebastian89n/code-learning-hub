package com.bastex.codelearninghub.jakartaee.jms.basics.features;

import com.bastex.codelearninghub.jakartaee.jms.basics.utils.JmsLogUtils;
import com.google.common.collect.EvictingQueue;
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
import java.time.Duration;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JmsAcknowledgmentTester {
    @SneakyThrows
    public static void testJmsAcknowledgment() {
        final InitialContext context = new InitialContext();
        final Queue requestQueue = (Queue) context.lookup("queue/requestQueue");

        testAutoAcknowledgment(requestQueue);
        testClientAcknowledgment(requestQueue);
        testDupOkAcknowledgment(requestQueue);
        testSessionTransactedAcknowledgment(requestQueue);
    }

    /**
     * Default acknowledgment type. Broker makes sure message is delivered only once
     */
    private static void testAutoAcknowledgment(final Queue requestQueue) {
        log.info("Testing AUTO_ACKNOWLEDGE");
        try (final ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
             final JMSContext jmsContext = connectionFactory.createContext(JMSContext.AUTO_ACKNOWLEDGE)) {
            final JMSProducer producer = jmsContext.createProducer();

            final TextMessage textMessage = jmsContext.createTextMessage("AUTO_ACKNOWLEDGE message");
            producer.send(requestQueue, textMessage);

            final JMSConsumer consumer = jmsContext.createConsumer(requestQueue);
            final Message receive = consumer.receive();
            JmsLogUtils.logTextMessage(receive);
        }
    }

    /**
     * Client needs to acknowledge messages manually in the code.
     * If the client fails to call acknowledge() after receiving a message, the JMS provider will not consider
     * the message as processed, and it will remain in the queue or topic for redelivery.
     */
    @SneakyThrows(JMSException.class)
    private static void testClientAcknowledgment(final Queue requestQueue) {
        log.info("Testing CLIENT_ACKNOWLEDGE");
        try (final ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
             final JMSContext jmsContext = connectionFactory.createContext(JMSContext.CLIENT_ACKNOWLEDGE)) {
            final JMSProducer producer = jmsContext.createProducer();

            final TextMessage textMessage = jmsContext.createTextMessage("CLIENT_ACKNOWLEDGE message");
            producer.send(requestQueue, textMessage);

            final JMSConsumer consumer = jmsContext.createConsumer(requestQueue);
            final Message message = consumer.receive();
            // process message
            JmsLogUtils.logTextMessage(message);
            // client acknowledges message manually
            message.acknowledge();
        }
    }

    /**
     * Duplicates may happen. In theory reduces overhead on the broker side
     * however brokers doesn't guarantee better performance as such.
     * Code should check if it should process the message again by storing JMSMessageId in the memory/db etc.
     */
    @SneakyThrows(InterruptedException.class)
    private static void testDupOkAcknowledgment(final Queue requestQueue) {
        log.info("Testing DUPS_OK_ACKNOWLEDGE");
        try (final ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
             final JMSContext jmsContext = connectionFactory.createContext(JMSContext.DUPS_OK_ACKNOWLEDGE)) {
            final JMSProducer producer = jmsContext.createProducer();

            final TextMessage textMessage = jmsContext.createTextMessage("DUPS_OK_ACKNOWLEDGE message");
            producer.send(requestQueue, textMessage);

            final JMSConsumer consumer = jmsContext.createConsumer(requestQueue);
            consumer.setMessageListener(new DupOkMessageListener());
            Thread.sleep(Duration.ofSeconds(2));
        }
    }

    /**
     * Messages are put/removed into queue/topic using commit/rollback methods
     */
    private static void testSessionTransactedAcknowledgment(final Queue requestQueue) {
        log.info("Testing SESSION_TRANSACTED");
        try (final ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
             final JMSContext jmsContext = connectionFactory.createContext(JMSContext.SESSION_TRANSACTED)) {
            final JMSProducer producer = jmsContext.createProducer();

            for (int i = 0; i < 3; i++) {
                final TextMessage textMessage = jmsContext.createTextMessage("SESSION_TRANSACTED message " + i);
                producer.send(requestQueue, textMessage);
            }

            // messages are put in the cache and only sent to the actual queue/topic once commit message is called
            jmsContext.commit();

            final TextMessage rollbackMessage = jmsContext.createTextMessage("SESSION_TRANSACTED message - rollback ");
            producer.send(requestQueue, rollbackMessage);
            // rollbacks message, it will not be put in the queue
            jmsContext.rollback();

            final JMSConsumer consumer = jmsContext.createConsumer(requestQueue);
            final Message receive = consumer.receive();
            JmsLogUtils.logTextMessage(receive);
            jmsContext.rollback();
            log.warn("Message rollback. It will be consumed again");

            for (int i = 0; i < 3; i++) {
                final Message receivedMessage = consumer.receive();
                JmsLogUtils.logTextMessage(receivedMessage);
            }
            // only after calling commit messages will be removed from the queue / topic
            jmsContext.commit();
        }
    }

    private static class DupOkMessageListener implements MessageListener {
        private final EvictingQueue<String> evictingQueue = EvictingQueue.create(50);

        @Override
        @SneakyThrows(JMSException.class)
        public void onMessage(final Message message) {
            final String jmsMessageId = message.getJMSMessageID();
            if (jmsMessageId != null && !evictingQueue.contains(jmsMessageId)) {
                // process message

                JmsLogUtils.logTextMessage(message);
                evictingQueue.add(jmsMessageId);
            } else {
                log.info("Ignoring jms message with id {}. Message already processed in the past.", jmsMessageId);
            }
        }
    }
}
