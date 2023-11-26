package com.bastex.codelearninghub.jakartaee.jms.basics.jms1x;

import com.bastex.codelearninghub.jakartaee.jms.basics.utils.JmsCommonUtils;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.jms.Connection;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import java.util.List;

import static com.bastex.codelearninghub.jakartaee.jms.basics.jms1x.Jms1xHelper.Jms1xConnection;

/**
 * Example of using JMS 1.x API for P2P.
 * Uses JNDI look up.
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.NONE)
public final class Jms1xPubSubTester {
    @SneakyThrows
    public static void testJms1xBasicsWithPubSub() {
        // uses jndi.properties files
        try (final Jms1xConnection jmsConnection = Jms1xHelper.openJmsConnection()) {
            final Session session = jmsConnection.session();
            final Topic destinationTopic = jmsConnection.topic();
            final Connection connection = jmsConnection.connection();

            final TextMessage message = session.createTextMessage("Topic message");
            final MessageProducer producer = session.createProducer(destinationTopic);

            final MessageConsumer consumer1 = session.createConsumer(destinationTopic);
            final MessageConsumer consumer2 = session.createConsumer(destinationTopic);

            producer.send(message);

            // for consuming we need to start the connection
            connection.start();
            final Message receivedMessage = consumer1.receive();
            final Message receivedMessage2 = consumer2.receive();

            JmsCommonUtils.logTextMessages(List.of(receivedMessage, receivedMessage2));
        }
    }
}
