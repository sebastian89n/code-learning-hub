package com.bastex.codelearninghub.jakartaee.jms.reply;

import com.bastex.codelearninghub.jakartaee.jms.utils.JmsCommonUtils;
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
import javax.jms.Queue;
import javax.jms.TemporaryQueue;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JmsReplyToTester {
    @SneakyThrows
    public static void testReplyTo() {
        final InitialContext context = new InitialContext();
        final Queue requestQueue = (Queue) context.lookup("queue/requestQueue");
//        final Queue replyQueue = (Queue) context.lookup("queue/replyQueue");

        try (final ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
             final JMSContext jmsContext = connectionFactory.createContext()) {
            // creates a temporary queue instead of using replyQueue from jndi
            final TemporaryQueue replyQueue = jmsContext.createTemporaryQueue();
            sendRequestMessage(jmsContext, requestQueue, replyQueue);

            final Message message = receiveMessage(jmsContext, requestQueue);

            replyToRequestMessage(jmsContext, message);
            receiveMessage(jmsContext, replyQueue);
        }
    }

    private static void sendRequestMessage(final JMSContext jmsContext, final Queue requestQueue, final Queue replyQueue) throws JMSException {
        final JMSProducer requestProducer = jmsContext.createProducer();

        final TextMessage requestMessage = jmsContext.createTextMessage();
        requestMessage.setText("Sending a request");
        requestMessage.setJMSReplyTo(replyQueue);

        requestProducer.send(requestQueue, requestMessage);
    }

    private static void replyToRequestMessage(final JMSContext jmsContext, final Message message) throws JMSException {
        final JMSProducer replyProducer = jmsContext.createProducer();

        // uses getJMSReplyTo() to get Destination to respond to
        replyProducer.send(message.getJMSReplyTo(), "Replying to a request");
    }

    private static Message receiveMessage(final JMSContext jmsContext, final Queue queue) throws JMSException {
        final JMSConsumer replyConsumer = jmsContext.createConsumer(queue);

        final Message receivedMessage = replyConsumer.receive();
        JmsCommonUtils.logTextMessage(receivedMessage);

        return receivedMessage;
    }
}
