package com.bastex.codelearninghub.jakartaee.jms.jms2x;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Queue;
import javax.naming.InitialContext;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Jms2xP2PTester {
    @SneakyThrows
    public static void testJms2xBasicsWithP2P() {
        final InitialContext context = new InitialContext();
        final Queue destinationQueue = (Queue) context.lookup("queue/myQueue");

        try (final ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
             final JMSContext jmsContext = connectionFactory.createContext()) {
            final JMSProducer producer = jmsContext.createProducer();
            producer.send(destinationQueue, "Queue message");

            final JMSConsumer consumer = jmsContext.createConsumer(destinationQueue);
            // receiveBody is used to extract content of the message directly
            final String messageContent = consumer.receiveBody(String.class);

            log.info("Message content: {}", messageContent);
            System.out.println("Message content: " + messageContent);
        }
    }
}
