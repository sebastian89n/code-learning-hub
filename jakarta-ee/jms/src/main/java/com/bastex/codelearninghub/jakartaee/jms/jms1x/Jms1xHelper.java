package com.bastex.codelearninghub.jakartaee.jms.jms1x;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.Topic;
import javax.naming.InitialContext;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Jms1xHelper {
    /**
     * Steps required to initialize JMS connection via JMS 1.x interface
     * Loaded using jndi.properties files.
     */
    @SneakyThrows
    public static JmsConnection openJmsConnection() {
        final InitialContext initialContext = new InitialContext();
        final ConnectionFactory connectionFactory = (ConnectionFactory) initialContext.lookup("ConnectionFactory");
        final Connection connection = connectionFactory.createConnection();

        final Session session = connection.createSession();
        final Queue destinationQueue = (Queue) initialContext.lookup("queue/myQueue");
        final Topic destinationTopic = (Topic) initialContext.lookup("topic/myTopic");

        return new JmsConnection(initialContext, connection, session, destinationQueue, destinationTopic);
    }

    public record JmsConnection(InitialContext initialContext,
                                Connection connection,
                                Session session,
                                Queue queue,
                                Topic topic) implements AutoCloseable {
        @Override
        public void close() throws Exception {
            if (initialContext != null) {
                initialContext.close();
            }

            if (session != null) {
                session.close();
            }
        }
    }
}
