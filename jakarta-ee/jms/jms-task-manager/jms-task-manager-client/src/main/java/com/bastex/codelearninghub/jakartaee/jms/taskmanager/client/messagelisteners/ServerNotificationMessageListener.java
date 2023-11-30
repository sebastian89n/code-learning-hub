package com.bastex.codelearninghub.jakartaee.jms.taskmanager.client.messagelisteners;

import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.notifications.ServerNotificationMessage;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@Slf4j
public class ServerNotificationMessageListener implements MessageListener {
    @Override
    @SneakyThrows(JMSException.class)
    public void onMessage(final Message message) {
        final ServerNotificationMessage serverNotificationMessage = message.getBody(ServerNotificationMessage.class);

        final String notification = serverNotificationMessage.getNotification();
        if (notification != null && !notification.isBlank()) {
            log.warn("Received notification from the server: {}", notification);
        } else {
            log.warn("Received notification from the server, but the message was empty");
        }
    }
}
