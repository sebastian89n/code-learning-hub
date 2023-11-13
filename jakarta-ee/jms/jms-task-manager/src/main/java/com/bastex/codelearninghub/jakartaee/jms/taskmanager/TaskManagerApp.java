package com.bastex.codelearninghub.jakartaee.jms.taskmanager;

import com.bastex.codelearninghub.jakartaee.jms.taskmanager.messagelisteners.RequestedTaskListener;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Slf4j
public class TaskManagerApp {
    public static void main(final String[] args) throws NamingException {
        final InitialContext initialContext = new InitialContext();
        final Queue queue = (Queue) initialContext.lookup("queue/requestQueue");

        try (final ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
             final JMSContext jmsContext = connectionFactory.createContext()) {
            final JMSConsumer consumer = jmsContext.createConsumer(queue);
            // sets asynchronous message listener in the consumer
            consumer.setMessageListener(new RequestedTaskListener());
        }
    }
}
