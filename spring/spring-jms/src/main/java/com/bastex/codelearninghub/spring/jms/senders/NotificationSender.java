package com.bastex.codelearninghub.spring.jms.senders;

import com.bastex.codelearninghub.spring.jms.model.NotificationJmsDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class NotificationSender {
    private final JmsTemplate jmsTemplate;

    private final String topicName;

    public NotificationSender(final JmsTemplate pubSubJmsTemplate, @Value("${topics.notificationTopic}") final String topicName) {
        this.jmsTemplate = pubSubJmsTemplate;
        this.topicName = topicName;
    }

    public void sendMessage(final NotificationJmsDTO notificationJmsDTO) {
        jmsTemplate.convertAndSend(topicName, notificationJmsDTO);
    }
}
