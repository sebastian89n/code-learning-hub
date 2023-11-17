package com.bastex.codelearninghub.jakartaee.jms.taskmanager.server;

import com.bastex.codelearninghub.jakartaee.jms.taskmanager.server.messagelisteners.TaskListener;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Queue;
import javax.jms.Topic;
import javax.naming.InitialContext;

@Slf4j
public class TaskManagerServerApp {
    public static void main(final String[] args) throws Exception {
        final InitialContext initialContext = new InitialContext();
        final Queue requestQueue = (Queue) initialContext.lookup("queue/taskRequestQueue");
        final Queue replyQueue = (Queue) initialContext.lookup("queue/taskReplyQueue");
        final Topic notificationTopic = (Topic) initialContext.lookup("topic/notificationTopic");

        try (final ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
             final JMSContext jmsContext = connectionFactory.createContext()) {
            final JMSConsumer consumer = jmsContext.createConsumer(requestQueue);
            final JMSProducer producer = jmsContext.createProducer();

            // sets asynchronous message listener in the consumer
            consumer.setMessageListener(new TaskListener(producer, replyQueue));

            Thread.currentThread().join();
        }
    }
}
