package com.bastex.codelearninghub.jakartaee.jms.basics.headers;

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

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JmsDelayMessageTester {
    @SneakyThrows
    public static void testJmsDelayMessage() {
        final InitialContext context = new InitialContext();
        final Queue destinationQueue = (Queue) context.lookup("queue/myQueue");

        try (final ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
             final JMSContext jmsContext = connectionFactory.createContext()) {
            final JMSProducer producer = jmsContext.createProducer();
            // set delay
            producer.setDeliveryDelay(3000);
            producer.send(destinationQueue, "Queue message");

            final JMSConsumer consumer = jmsContext.createConsumer(destinationQueue);
            final Message message = consumer.receive();
            JmsCommonUtils.logTextMessage(message);
        }
    }
}
