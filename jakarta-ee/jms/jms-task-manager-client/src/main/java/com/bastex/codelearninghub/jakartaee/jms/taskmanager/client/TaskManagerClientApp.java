package com.bastex.codelearninghub.jakartaee.jms.taskmanager.client;

import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.naming.InitialContext;

@Slf4j
public class TaskManagerClientApp {
    public static void main(final String[] args) throws Exception {
        final InitialContext initialContext = new InitialContext();
        final Queue queue = (Queue) initialContext.lookup("queue/requestQueue");

        try (final ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
             final JMSContext jmsContext = connectionFactory.createContext()) {
            log.info("Task Manager Client started");
            while (true) {
                log.info("");
                final JMSProducer producer = jmsContext.createProducer();
                final ObjectMessage objectMessage = jmsContext.createObjectMessage();
            }
        }
    }
}
