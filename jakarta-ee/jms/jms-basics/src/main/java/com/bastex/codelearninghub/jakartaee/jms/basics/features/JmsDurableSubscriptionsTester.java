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
import java.time.Duration;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JmsDurableSubscriptionsTester {
    private static final String SUBSCRIPTION_NAME = "sub-1";

    @SneakyThrows
    public static void testDurableSubscriptions() {
        final InitialContext context = new InitialContext();
        final Topic topic = (Topic) context.lookup("topic/myTopic");

        try (final ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
             final JMSContext jmsContext = connectionFactory.createContext()) {
            jmsContext.setClientID("durable-sub-1");

            log.info("Registered durable consumer");
            final JMSConsumer durableConsumer = createDurableConsumer(jmsContext, topic);
            durableConsumer.close();
            log.info("Registered consumer is closed");

            sendMessageToTopic(jmsContext, topic);
            log.info("Message to topic has been sent");

            Thread.sleep(Duration.ofSeconds(1));

            log.info("Creating durable consumer again");
            final JMSConsumer consumer = createDurableConsumer(jmsContext, topic);
            final Message receivedMessage = consumer.receive();
            JmsLogUtils.logTextMessage(receivedMessage);
            consumer.close();

            // only after calling unsubscribe durable consumer will get unsubscribed from the broker
            jmsContext.unsubscribe(SUBSCRIPTION_NAME);
            log.info("Subscription {} has been unsubscribed", SUBSCRIPTION_NAME);
        }
    }

    /**
     * Creates a consumer that is registered in the Broker as durable consumer.
     * If this consumer goes down, broker won't delete the published message until it's delivered to this consumer.
     */
    private static JMSConsumer createDurableConsumer(final JMSContext jmsContext, final Topic topic) {
        return jmsContext.createDurableConsumer(topic, SUBSCRIPTION_NAME);
    }

    private static void sendMessageToTopic(final JMSContext jmsContext, final Topic destinationTopic) {
        final JMSProducer producer = jmsContext.createProducer();
        final TextMessage message = jmsContext.createTextMessage("Sub message");
        producer.send(destinationTopic, message);
    }
}
