package com.bastex.codelearninghub.jakartaee.jms.taskmanager.client.messagelisteners;

import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.responses.TaskReply;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@Slf4j
public class TaskReplyMessageListener implements MessageListener {
    @Override
    @SneakyThrows(JMSException.class)
    public void onMessage(final Message message) {
        final TaskReply taskReply = message.getBody(TaskReply.class);
        log.info("Task {} has finished with status {}", taskReply.getTaskUuid(), taskReply.getStatus());
    }
}
