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
import javax.jms.TextMessage;
import javax.naming.InitialContext;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JmsCustomPropertiesTester {
    @SneakyThrows
    public static void testMessageCustomProperties() {
        final InitialContext context = new InitialContext();
        final Queue destinationQueue = (Queue) context.lookup("queue/myQueue");

        try (final ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
             final JMSContext jmsContext = connectionFactory.createContext()) {
            final JMSProducer producer = jmsContext.createProducer();

            final TextMessage requestMessage = jmsContext.createTextMessage("Queue message");
            requestMessage.setBooleanProperty("loggedIn", true);
            requestMessage.setStringProperty("userToken", "token123");

            producer.send(destinationQueue, requestMessage);

            final JMSConsumer consumer = jmsContext.createConsumer(destinationQueue);
            final Message receivedMessage = consumer.receive();
            final boolean loggedIn = receivedMessage.getBooleanProperty("loggedIn");
            final String userToken = receivedMessage.getStringProperty("userToken");

            JmsCommonUtils.logTextMessage(receivedMessage);
        }
    }
}
