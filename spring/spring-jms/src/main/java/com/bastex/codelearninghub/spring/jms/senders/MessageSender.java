package com.bastex.codelearninghub.spring.jms.senders;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {
    private final JmsTemplate jmsTemplate;

    private final String queue;

    public MessageSender(final JmsTemplate jmsTemplate, @Value("${queues.taskQueue}") final String queue) {
        this.jmsTemplate = jmsTemplate;
        this.queue = queue;
    }

    public void sendText(final String message) {
        jmsTemplate.convertAndSend(queue, message);
    }

    public void sendObject(final Object object) {
//        MessageCreator messageCreator = session -> session.createObjectMessage().setObject();
        jmsTemplate.setPubSubDomain(false);
    }
}
