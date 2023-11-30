package com.bastex.codelearninghub.jakartaee.jms.basics.features;

import com.bastex.codelearninghub.jakartaee.jms.basics.utils.JmsLogUtils;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.naming.InitialContext;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JmsSharedSubscriptionsTester {
    private static final String SUBSCRIPTION_NAME = "shared-sub";

    @SneakyThrows
    public static void testSharedSubscriptions() {
        final InitialContext context = new InitialContext();
        final Topic topic = (Topic) context.lookup("topic/myTopic");

        try (final ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
             final JMSContext jmsContext = connectionFactory.createContext()) {
            jmsContext.setClientID("shared-sub-client-1");

            final JMSConsumer sharedConsumer1 = jmsContext.createSharedConsumer(topic, SUBSCRIPTION_NAME);
            final JMSConsumer sharedConsumer2 = jmsContext.createSharedConsumer(topic, SUBSCRIPTION_NAME);
            log.info("Created 2 shared consumers");

            for (int i = 0; i < 10; i++) {
                sendMessageToTopic(jmsContext, topic, i);
            }

            for (int i = 0; i < 5; i++) {
                final Message message1 = sharedConsumer1.receive();
                log.info("Message received by shared consumer 1");
                JmsLogUtils.logTextMessage(message1);

                final Message message2 = sharedConsumer2.receive();
                log.info("Message received by shared consumer 2");
                JmsLogUtils.logTextMessage(message2);
            }
        }
    }

    private static void sendMessageToTopic(final JMSContext jmsContext, final Topic destinationTopic, final int index) {
        final JMSProducer producer = jmsContext.createProducer();
        final TextMessage message = jmsContext.createTextMessage("Sub message for shared subscriptions - " + index);
        producer.send(destinationTopic, message);
    }
}
