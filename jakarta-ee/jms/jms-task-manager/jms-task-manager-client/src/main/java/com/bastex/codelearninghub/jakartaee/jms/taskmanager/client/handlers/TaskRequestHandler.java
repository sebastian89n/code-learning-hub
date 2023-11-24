package com.bastex.codelearninghub.jakartaee.jms.taskmanager.client.handlers;

import com.bastex.codelearninghub.jakartaee.jms.taskmanager.client.utils.TaskFromCLICreator;
import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.exceptions.CLIInputException;
import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.tasks.requests.TaskRequest;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import java.util.Optional;
import java.util.Scanner;

@Slf4j
public final class TaskRequestHandler {
    private final JMSContext jmsContext;

    private final JMSProducer jmsProducer;

    private final Queue taskRequestQueue;

    public TaskRequestHandler(final JMSContext jmsContext, final Queue taskRequestQueue) {
        this.jmsContext = jmsContext;
        this.jmsProducer = jmsContext.createProducer();
        this.taskRequestQueue = taskRequestQueue;
    }

    @SneakyThrows(JMSException.class)
    public void handleTaskRequests() {
        final TaskFromCLICreator taskFromCLICreator = new TaskFromCLICreator(new Scanner(System.in));

        boolean keepCreatingTasks = true;
        do {
            try {
                final Optional<TaskRequest> task = taskFromCLICreator.createTaskFromUserInput();
                keepCreatingTasks = task.isPresent();
                task.ifPresent(this::sendTask);
            } catch (final CLIInputException e) {
                log.warn("Provided invalid input, please try again. ", e);
            }
        } while (keepCreatingTasks);
    }

    private void sendTask(final TaskRequest taskRequestToSend) throws JMSException {
        final ObjectMessage objectMessage = jmsContext.createObjectMessage();
        objectMessage.setObject(taskRequestToSend);
        jmsProducer.send(taskRequestQueue, objectMessage);

        log.info("Sent task with uuid {}", taskRequestToSend.getTaskUuid());
    }
}
