package com.bastex.codelearninghub.jakartaee.jms.basics.features;

import com.bastex.codelearninghub.jakartaee.jms.basics.utils.JmsLogUtils;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JmsMessageGroupingTester {
    // header used to specify group name
    private static final String GROUP_ID_HEADER_NAME = "JMSXGroupID";

    @SneakyThrows
    public static void testMessageGrouping() {
        final InitialContext context = new InitialContext();
        final Queue destinationQueue = (Queue) context.lookup("queue/myQueue");

        try (final ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
             final JMSContext jmsContext = connectionFactory.createContext();
             final JMSContext jmsContext2 = connectionFactory.createContext()) {

            final JMSProducer producer = jmsContext.createProducer();

            final JMSConsumer consumer = jmsContext2.createConsumer(destinationQueue);
            consumer.setMessageListener(new GroupingMessageListener("Message Listener 1"));

            final JMSConsumer consumer2 = jmsContext2.createConsumer(destinationQueue);
            consumer2.setMessageListener(new GroupingMessageListener("Message Listener 2"));

            final int messageCount = 10;
            for (int i = 0; i < messageCount; i++) {
                final TextMessage message = jmsContext.createTextMessage("Group-0 message-" + i);
                // messages with the same JMSXGroupID header will be consumed by the same consumer
                message.setStringProperty(GROUP_ID_HEADER_NAME, "Group-0");
                producer.send(destinationQueue, message);
            }

            Thread.currentThread().join();
        }
    }

    @RequiredArgsConstructor
    private static class GroupingMessageListener implements MessageListener {
        private final String consumerName;

        @Override
        public void onMessage(final Message message) {
            log.info("Message consumed by consumer {}", consumerName);
            JmsLogUtils.logTextMessage(message);
        }
    }
}
