package com.bastex.codelearninghub.jakartaee.jms.basics.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.jms.Message;
import javax.jms.TextMessage;
import java.util.Collection;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JmsLogUtils {
    @SneakyThrows
    public static void logTextMessages(@NonNull final Collection<Message> messagesToLog) {
        messagesToLog.forEach(JmsLogUtils::logTextMessage);
    }

    @SneakyThrows
    public static void logTextMessage(final Message messageToLog) {
        if (messageToLog == null) {
            log.warn("Message is null");
        } else if (messageToLog instanceof final TextMessage textMessage) {
            log.info("Received message: {}", textMessage.getText());
        }
    }
}
