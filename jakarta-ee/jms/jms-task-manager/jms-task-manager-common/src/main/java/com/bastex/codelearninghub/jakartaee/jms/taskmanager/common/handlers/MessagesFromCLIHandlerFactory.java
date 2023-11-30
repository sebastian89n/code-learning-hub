package com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.handlers;

import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.common.MessageWithUuid;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.Queue;
import java.util.Optional;
import java.util.function.Supplier;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MessagesFromCLIHandlerFactory {
    public static <T extends MessageWithUuid> MessagesFromCLIHandler<T> createHandlerWithReply(final JMSContext jmsContext,
                                                                                               final Destination destination,
                                                                                               final Queue replyQueue,
                                                                                               final Supplier<Optional<T>> messageFromCLISupplier) {
        return new MessagesFromCLIHandler<>(jmsContext, destination, replyQueue, messageFromCLISupplier);
    }

    public static <T extends MessageWithUuid> MessagesFromCLIHandler<T> createHandlerWithoutReply(final JMSContext jmsContext,
                                                                                                  final Destination destination,
                                                                                                  final Supplier<Optional<T>> messageFromCLISupplier) {
        return new MessagesFromCLIHandler<>(jmsContext, destination, messageFromCLISupplier);
    }
}
