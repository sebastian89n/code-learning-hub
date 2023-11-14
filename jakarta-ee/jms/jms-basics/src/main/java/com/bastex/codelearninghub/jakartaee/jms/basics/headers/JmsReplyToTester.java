package com.bastex.codelearninghub.jakartaee.jms.basics.headers;

import com.bastex.codelearninghub.jakartaee.jms.basics.utils.JmsCommonUtils;
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
import javax.jms.TextMessage;
import javax.naming.InitialContext;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JmsReplyToTester {
    @SneakyThrows
    public static void testJmsReplyTo() {
        final InitialContext context = new InitialContext();
        final Queue requestQueue = (Queue) context.lookup("queue/requestQueue");
        final Queue replyQueue = (Queue) context.lookup("queue/replyQueue");

        try (final ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
             final JMSContext jmsContext = connectionFactory.createContext()) {
            // example of how to create a temporary queue
            // final TemporaryQueue replyQueue = jmsContext.createTemporaryQueue();
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
        // setting replyTo destination in the message
        requestMessage.setJMSReplyTo(replyQueue);

        requestProducer.send(requestQueue, requestMessage);
    }

    private static void replyToRequestMessage(final JMSContext jmsContext, final Message requestMessage) throws JMSException {
        final JMSProducer replyProducer = jmsContext.createProducer();

        final TextMessage replyMessage = jmsContext.createTextMessage("Replying to a request");

        log.info("Setting correlation id to message id: {}", requestMessage.getJMSMessageID());

        // optionally we can set correlationID to be the messageId of the request Message
        replyMessage.setJMSCorrelationID(requestMessage.getJMSMessageID());

        // uses getJMSReplyTo() to get Destination to respond to
        replyProducer.send(requestMessage.getJMSReplyTo(), replyMessage);
    }

    private static Message receiveMessage(final JMSContext jmsContext, final Queue queue) throws JMSException {
        final JMSConsumer replyConsumer = jmsContext.createConsumer(queue);

        final Message receivedMessage = replyConsumer.receive();
        JmsCommonUtils.logTextMessage(receivedMessage);
        log.info("Received message with correlation id: {}", receivedMessage.getJMSCorrelationID());

        return receivedMessage;
    }
}
