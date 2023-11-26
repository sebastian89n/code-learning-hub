package com.bastex.codelearninghub.jakartaee.jms.basics.features;

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
import javax.jms.TextMessage;
import javax.naming.InitialContext;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JmsPriorityTester {
    @SneakyThrows
    public static void testJmsPriority() {
        final InitialContext context = new InitialContext();
        final Queue destinationQueue = (Queue) context.lookup("queue/myQueue");

        try (final ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
             final JMSContext jmsContext = connectionFactory.createContext()) {
            final JMSProducer producer = jmsContext.createProducer();

            final String[] messages = new String[3];
            messages[0] = "First message";
            messages[1] = "Second message";
            messages[2] = "Third message";

            // 0-9, 0 - lowest priority, 9 highest priority. Default is 4.
            producer.setPriority(3);
            producer.send(destinationQueue, messages[0]);

            producer.setPriority(1);
            producer.send(destinationQueue, messages[1]);

            producer.setPriority(9);
            producer.send(destinationQueue, messages[2]);

            final JMSConsumer consumer = jmsContext.createConsumer(destinationQueue);

            for (int i = 0; i < messages.length; i++) {
                final Message message = consumer.receive();
                if (message instanceof final TextMessage textMessage) {
                    log.info("Message priority: {}, content: {}", message.getJMSPriority(), textMessage.getText());
                }
            }
        }
    }
}
