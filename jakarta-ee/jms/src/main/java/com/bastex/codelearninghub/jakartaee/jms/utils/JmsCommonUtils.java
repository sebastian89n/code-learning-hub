package com.bastex.codelearninghub.jakartaee.jms.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JmsCommonUtils {
    public static void logTextMessage(final Message messageToLog) throws JMSException {
        if (messageToLog instanceof final TextMessage textMessage) {
            log.info("Received message: {}", textMessage.getText());
            System.out.println("Received message: " + textMessage.getText());
        }
    }
}
