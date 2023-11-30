package com.bastex.codelearninghub.jakartaee.jms.basics.jms1x;

import com.bastex.codelearninghub.jakartaee.jms.basics.jms1x.Jms1xHelper.Jms1xConnection;
import com.bastex.codelearninghub.jakartaee.jms.basics.utils.JmsLogUtils;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.Session;
import javax.jms.TextMessage;
import java.util.Enumeration;

/**
 * Example of using JMS 1.x API for P2P.
 * Uses JNDI look up.
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.NONE)
public final class Jms1xQueueBrowserTester {
    @SneakyThrows
    public static void testJms1xQueueBrowser() {
        try (final Jms1xConnection jmsConnection = Jms1xHelper.openJmsConnection()) {
            final Session session = jmsConnection.session();
            final Queue destinationQueue = jmsConnection.queue();

            final MessageProducer producer = session.createProducer(destinationQueue);

            final TextMessage message1 = session.createTextMessage("Queue message");
            final TextMessage message2 = session.createTextMessage("Queue message");

            producer.send(message1);
            producer.send(message2);

            final QueueBrowser browser = session.createBrowser(destinationQueue);

            browseMessagesInQueue(browser);

            final MessageConsumer consumer = session.createConsumer(destinationQueue);
            jmsConnection.connection().start();
            final Message receivedMessage1 = consumer.receive(5000);
            JmsLogUtils.logTextMessage(receivedMessage1);
            final Message receivedMessage2 = consumer.receive(5000);
            JmsLogUtils.logTextMessage(receivedMessage2);
        }
    }

    private static void browseMessagesInQueue(final QueueBrowser browser) throws JMSException {
        log.info("Logging messages from QueueBrowser: ");
        final Enumeration messagesEnumeration = browser.getEnumeration();
        while (messagesEnumeration.hasMoreElements()) {
            final Object obj = messagesEnumeration.nextElement();
            if (obj instanceof final TextMessage textMessage) {
                JmsLogUtils.logTextMessage(textMessage);
            }
        }
        log.info("All messages from QueueBrowser were logged");
    }
}
