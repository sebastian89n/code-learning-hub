package com.bastex.codelearninghub.jakartaee.jms.taskmanager.messagelisteners;

import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.requests.NotificationTask;
import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.requests.ScheduledTask;
import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.responses.TaskReply;
import com.bastex.codelearninghub.jakartaee.jms.taskmanager.processors.NotificationTaskProcessor;
import com.bastex.codelearninghub.jakartaee.jms.taskmanager.processors.ScheduledTaskProcessor;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import java.io.Serializable;

@RequiredArgsConstructor
public class TaskListener implements MessageListener {
    private final JMSProducer producer;

    private final Queue taskReplyQueue;

    @Override
    @SneakyThrows(JMSException.class)
    public void onMessage(final Message message) {
        final ObjectMessage objectMessage = (ObjectMessage) message;
        final Serializable object = objectMessage.getObject();

        final TaskReply taskReply = switch (object) {
            case final ScheduledTask scheduledTask -> new ScheduledTaskProcessor().processTask(scheduledTask);
            case final NotificationTask notificationTask ->
                    new NotificationTaskProcessor().processTask(notificationTask);
            default -> throw new IllegalStateException("Unhandled task type");
        };

        producer.send(taskReplyQueue, taskReply);
    }
}
