package com.bastex.codelearninghub.spring.jms.listeners;

import com.bastex.codelearninghub.spring.jms.model.TaskJmsDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TaskMessageListener {

    /**
     * Use of JmsListener annotation to easily create a consumer on given Destination
     */
    @JmsListener(destination = "${queues.taskQueue}")
    public void receive(final TaskJmsDTO message) {
        log.info("Received message from task queue: {}", message);
    }
}
