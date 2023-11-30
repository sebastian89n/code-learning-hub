package com.bastex.codelearninghub.jakartaee.jms.basics.jms1x;

import com.bastex.codelearninghub.jakartaee.jms.basics.utils.JmsLogUtils;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.jms.Connection;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * Example of using JMS 1.x API for P2P.
 * Uses JNDI look up.
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.NONE)
public final class Jms1xP2PTester {
    @SneakyThrows
    public static void testJms1xBasicsWithP2P() {

        try (final Jms1xHelper.Jms1xConnection jmsConnection = Jms1xHelper.openJmsConnection()) {
            final Connection connection = jmsConnection.connection();
            final Session session = jmsConnection.session();
            final Queue destinationQueue = jmsConnection.queue();

            final TextMessage message = session.createTextMessage("Queue message");

            final MessageProducer producer = session.createProducer(destinationQueue);
            producer.send(message);

            final MessageConsumer consumer = session.createConsumer(destinationQueue);
            // for consuming we need to start the connection
            connection.start();
            final Message receivedMessage = consumer.receive();
            JmsLogUtils.logTextMessage(receivedMessage);
        }
    }
}
