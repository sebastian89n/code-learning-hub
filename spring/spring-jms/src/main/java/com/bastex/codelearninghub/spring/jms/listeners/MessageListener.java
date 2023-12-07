package com.bastex.codelearninghub.spring.jms.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageListener {

    @JmsListener(destination = "${queues.taskQueue}")
    public void receive(final String message) {
        log.info("Received message from JMS: {}", message);
    }
}
