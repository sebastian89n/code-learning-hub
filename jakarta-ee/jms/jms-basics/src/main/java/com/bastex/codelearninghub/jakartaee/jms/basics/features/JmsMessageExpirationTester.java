package com.bastex.codelearninghub.jakartaee.jms.basics.features;

import com.bastex.codelearninghub.jakartaee.jms.basics.utils.JmsCommonUtils;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.jms.Queue;
import javax.naming.InitialContext;
import java.time.Duration;

/**
 * Expired message will be moved to expiry queue
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JmsMessageExpirationTester {
    @SneakyThrows
    public static void testMessageExpiration() {
        final InitialContext context = new InitialContext();
        final Queue destinationQueue = (Queue) context.lookup("queue/myQueue");
        final Queue expiryQueue = (Queue) context.lookup("queue/expiryQueue");

        try (final ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
             final JMSContext jmsContext = connectionFactory.createContext()) {
            final JMSProducer producer = jmsContext.createProducer();
            // sets expiration on the message
            producer.setTimeToLive(2000L);
            producer.send(destinationQueue, "Queue message");

            // we sleep for 3 seconds for message to expire
            Thread.sleep(Duration.ofSeconds(3));

            final JMSConsumer consumer = jmsContext.createConsumer(destinationQueue);
            // setting how long we should wait to receive a new message
            final Message message = consumer.receive(2000L);
            JmsCommonUtils.logTextMessage(message);

            final JMSConsumer expiryConsumer = jmsContext.createConsumer(expiryQueue);
            final Message expiredMessage = expiryConsumer.receive();
            JmsCommonUtils.logTextMessage(expiredMessage);
        }
    }
}
