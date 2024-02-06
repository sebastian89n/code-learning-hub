package com.bastex.codelearninghub.spring.jms.listeners;

import com.bastex.codelearninghub.spring.jms.model.NotificationJmsDTO;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.ObjectMessage;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Slf4j
public class NotificationMessageListener implements MessageListener {
    @Override
    @SneakyThrows
    public void onMessage(final Message message) {
        if (message instanceof final ObjectMessage objectMessage) {
            final Serializable object = objectMessage.getObject();
            if (object instanceof final NotificationJmsDTO notificationJmsDTO) {
                log.info("Received message from notification topic: {}", notificationJmsDTO);
            }
        }
    }
}
