package com.bastex.codelearninghub.jakartaee.jms.taskmanager.client;

import com.bastex.codelearninghub.jakartaee.jms.taskmanager.client.handlers.TaskRequestHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.naming.InitialContext;

@Slf4j
public class TaskManagerClientApp {
    public static void main(final String[] args) throws Exception {
        final InitialContext initialContext = new InitialContext();
        final Queue taskRequestQueue = (Queue) initialContext.lookup("queue/taskRequestQueue");

        try (final ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
             final JMSContext jmsContext = connectionFactory.createContext()) {
            log.info("Task Manager Client started");

            final TaskRequestHandler taskRequestHandler = new TaskRequestHandler(jmsContext, taskRequestQueue);
            taskRequestHandler.handleTaskRequests();
        }
    }
}
