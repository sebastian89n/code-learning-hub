package com.bastex.codelearninghub.jakartaee.jms.taskmanager.client;

import com.bastex.codelearninghub.jakartaee.jms.taskmanager.client.exceptions.InvalidInputException;
import com.bastex.codelearninghub.jakartaee.jms.taskmanager.client.utils.InputReader;
import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.Task;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.naming.InitialContext;
import java.util.Optional;
import java.util.Scanner;

@Slf4j
public class TaskManagerClientApp {
    public static void main(final String[] args) throws Exception {
        final InitialContext initialContext = new InitialContext();
        final Queue queue = (Queue) initialContext.lookup("queue/taskRequestQueue");

        try (final ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
             final JMSContext jmsContext = connectionFactory.createContext()) {
            final JMSProducer producer = jmsContext.createProducer();
            log.info("Task Manager Client started");
            final InputReader inputReader = new InputReader(new Scanner(System.in));

            while (true) {
                try {
                    final Optional<Task> task = inputReader.readTask();
                    if (task.isPresent()) {
                        final ObjectMessage objectMessage = jmsContext.createObjectMessage();
                        objectMessage.setObject(task.get());
                        producer.send(queue, objectMessage);
                    } else {
                        break;
                    }
                } catch (final InvalidInputException e) {
                    log.warn("Provided invalid input, please try again. ", e);
                }
            }
        }
    }
}
