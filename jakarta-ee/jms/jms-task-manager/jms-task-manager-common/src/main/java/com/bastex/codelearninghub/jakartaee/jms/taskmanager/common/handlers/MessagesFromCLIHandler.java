package com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.handlers;

import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.exceptions.CLIInputException;
import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.common.MessageWithUuid;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.ObjectMessage;
import java.util.Optional;
import java.util.function.Supplier;

@Slf4j
public final class MessagesFromCLIHandler<T extends MessageWithUuid> {
    private final JMSContext jmsContext;

    private final JMSProducer jmsProducer;

    private final Destination destination;

    private final Supplier<Optional<T>> messageFromCLISupplier;

    public MessagesFromCLIHandler(final JMSContext jmsContext, final Destination destination, final Supplier<Optional<T>> messageFromCLISupplier) {
        this.jmsContext = jmsContext;
        this.jmsProducer = jmsContext.createProducer();
        this.destination = destination;
        this.messageFromCLISupplier = messageFromCLISupplier;
    }

    public void handleMessagesFromCLI() {
        boolean keepCreatingTasks = true;
        do {
            try {
                final Optional<T> createdMessage = messageFromCLISupplier.get();
                createdMessage.ifPresent(this::sendTask);
                keepCreatingTasks = createdMessage.isPresent();
            } catch (final CLIInputException e) {
                log.warn("Provided invalid input, please try again. ", e);
            }
        } while (keepCreatingTasks);
    }

    @SneakyThrows(JMSException.class)
    private void sendTask(final T messageToSend) {
        final ObjectMessage objectMessage = jmsContext.createObjectMessage();
        objectMessage.setObject(messageToSend);
        jmsProducer.send(destination, objectMessage);

        log.info("Sent message with uuid {}", messageToSend.getUuid());
    }
}
