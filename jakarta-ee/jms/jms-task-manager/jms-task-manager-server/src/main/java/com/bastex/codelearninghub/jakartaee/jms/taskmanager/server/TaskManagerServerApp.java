package com.bastex.codelearninghub.jakartaee.jms.taskmanager.server;

import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.handlers.MessagesFromCLIHandler;
import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.notifications.ServerNotificationMessage;
import com.bastex.codelearninghub.jakartaee.jms.taskmanager.server.messagelisteners.TaskListener;
import com.bastex.codelearninghub.jakartaee.jms.taskmanager.server.utils.NotificationFromCLICreator;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Queue;
import javax.jms.Topic;
import javax.naming.InitialContext;
import java.util.Scanner;

@Slf4j
public class TaskManagerServerApp {
    public static void main(final String[] args) throws Exception {
        final InitialContext initialContext = new InitialContext();
        final Queue requestQueue = (Queue) initialContext.lookup("queue/taskRequestQueue");
        final Topic notificationTopic = (Topic) initialContext.lookup("topic/notificationTopic");

        try (final ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
             final JMSContext jmsContext = connectionFactory.createContext()) {
            final JMSConsumer consumer = jmsContext.createConsumer(requestQueue);
            final JMSProducer producer = jmsContext.createProducer();

            consumer.setMessageListener(new TaskListener(producer));

            final MessagesFromCLIHandler<ServerNotificationMessage> messagesFromCLIHandler = prepareMessagesHandler(jmsContext, notificationTopic);
            messagesFromCLIHandler.handleMessagesFromCLI();

            Thread.currentThread().join();
        }
    }

    private static MessagesFromCLIHandler<ServerNotificationMessage> prepareMessagesHandler(final JMSContext jmsContext, final Topic notificationTopic) {
        final NotificationFromCLICreator notificationFromCLICreator = new NotificationFromCLICreator(new Scanner(System.in));
        return new MessagesFromCLIHandler<>(jmsContext,
                notificationTopic,
                notificationFromCLICreator::createNotificationFromUserInput);
    }
}
