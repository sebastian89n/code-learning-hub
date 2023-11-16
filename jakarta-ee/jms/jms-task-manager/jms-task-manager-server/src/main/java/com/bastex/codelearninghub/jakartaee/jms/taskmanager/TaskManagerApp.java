package com.bastex.codelearninghub.jakartaee.jms.taskmanager;

import com.bastex.codelearninghub.jakartaee.jms.taskmanager.messagelisteners.TaskListener;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.naming.InitialContext;

@Slf4j
public class TaskManagerApp {
    public static void main(final String[] args) throws Exception {
        final InitialContext initialContext = new InitialContext();
        final Queue requestQueue = (Queue) initialContext.lookup("queue/taskRequestQueue");
        final Queue replyQueue = (Queue) initialContext.lookup("queue/taskReplyQueue");

        try (final ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
             final JMSContext jmsContext = connectionFactory.createContext()) {
            final JMSConsumer consumer = jmsContext.createConsumer(requestQueue);
            // sets asynchronous message listener in the consumer
            consumer.setMessageListener(new TaskListener(jmsContext.createProducer(), replyQueue));
            Thread.currentThread().join();
        }
    }
}
