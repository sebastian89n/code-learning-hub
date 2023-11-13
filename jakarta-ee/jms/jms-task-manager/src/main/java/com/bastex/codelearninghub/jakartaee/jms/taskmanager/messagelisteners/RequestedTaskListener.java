package com.bastex.codelearninghub.jakartaee.jms.taskmanager.messagelisteners;

import lombok.SneakyThrows;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import java.io.Serializable;

public class RequestedTaskListener implements MessageListener {
    @Override
    @SneakyThrows(JMSException.class)
    public void onMessage(final Message message) {
        final ObjectMessage objectMessage = (ObjectMessage) message;
        final Serializable object = objectMessage.getObject();
    }
}
