package com.bastex.codelearninghub.spring.jms.senders;

import com.bastex.codelearninghub.spring.jms.model.TaskJmsDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * Example of a wrapper class that uses JmsTemplate to send messages to queue
 */
@Component
public class TaskSender {
    private final JmsTemplate jmsTemplate;

    private final String queue;

    public TaskSender(final JmsTemplate p2pJmsTemplate, @Value("${queues.taskQueue}") final String queue) {
        this.jmsTemplate = p2pJmsTemplate;
        this.queue = queue;
    }

    public void sendTask(final TaskJmsDTO message) {
        jmsTemplate.convertAndSend(queue, message);
    }
}
