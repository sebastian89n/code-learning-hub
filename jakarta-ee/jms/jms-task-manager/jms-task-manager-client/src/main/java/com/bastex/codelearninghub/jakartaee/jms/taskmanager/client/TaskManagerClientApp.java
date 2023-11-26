package com.bastex.codelearninghub.jakartaee.jms.taskmanager.client;

import com.bastex.codelearninghub.jakartaee.jms.taskmanager.client.messagelisteners.ServerNotificationMessageListener;
import com.bastex.codelearninghub.jakartaee.jms.taskmanager.client.messagelisteners.TaskReplyMessageListener;
import com.bastex.codelearninghub.jakartaee.jms.taskmanager.client.utils.TaskFromCLICreator;
import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.handlers.MessagesFromCLIHandler;
import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.tasks.requests.TaskRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.jms.Topic;
import javax.naming.InitialContext;
import java.util.Scanner;

@Slf4j
public class TaskManagerClientApp {
    public static void main(final String[] args) throws Exception {
        final InitialContext initialContext = new InitialContext();
        final Queue taskRequestQueue = (Queue) initialContext.lookup("queue/taskRequestQueue");
        final Queue taskReplyQueue = (Queue) initialContext.lookup("queue/taskReplyQueue");
        final Topic notificationTopic = (Topic) initialContext.lookup("topic/notificationTopic");

        try (final ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
             final JMSContext jmsContext = connectionFactory.createContext()) {
            jmsContext.setClientID("task-manager-client-1");
            log.info("Task Manager Client started");

            initializeMessageConsumers(jmsContext, taskReplyQueue, notificationTopic);

            final MessagesFromCLIHandler<TaskRequest> messagesFromCLIHandler = prepareMessagesHandler(jmsContext, taskRequestQueue, taskReplyQueue);
            messagesFromCLIHandler.handleMessagesFromCLI();

            Thread.currentThread().join();
        }
    }

    private static MessagesFromCLIHandler<TaskRequest> prepareMessagesHandler(final JMSContext jmsContext, final Queue taskRequestQueue, final Queue taskReplyQueue) {
        final TaskFromCLICreator taskFromCLICreator = new TaskFromCLICreator(new Scanner(System.in));

        return new MessagesFromCLIHandler<>(jmsContext,
                taskRequestQueue,
                taskReplyQueue,
                taskFromCLICreator::createTaskFromUserInput);
    }

    private static void initializeMessageConsumers(final JMSContext jmsContext, final Queue taskReplyQueue, final Topic notificationTopic) {
        final JMSConsumer taskReplyConsumer = jmsContext.createConsumer(taskReplyQueue);
        taskReplyConsumer.setMessageListener(new TaskReplyMessageListener());

        final JMSConsumer notificationConsumer = jmsContext.createConsumer(notificationTopic);
        notificationConsumer.setMessageListener(new ServerNotificationMessageListener());
    }
}
