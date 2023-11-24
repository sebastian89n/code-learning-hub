package com.bastex.codelearninghub.jakartaee.jms.taskmanager.server.messagelisteners;

import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.common.MessageWithUuid;
import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.tasks.requests.ScheduledTaskRequest;
import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.tasks.responses.TaskReply;
import com.bastex.codelearninghub.jakartaee.jms.taskmanager.server.processors.ScheduledTaskProcessor;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Queue;

@RequiredArgsConstructor
@Slf4j
public class TaskListener implements MessageListener {
    private final JMSProducer producer;

    private final Queue taskReplyQueue;
    private final ScheduledTaskProcessor scheduledTaskProcessor = new ScheduledTaskProcessor();

    @Override
    @SneakyThrows(JMSException.class)
    public void onMessage(final Message message) {
        final ObjectMessage objectMessage = (ObjectMessage) message;
        final MessageWithUuid messageWithUuid = (MessageWithUuid) objectMessage.getObject();
        log.info("Received task with uuid: {}", messageWithUuid.getUuid());

        final TaskReply taskReply = switch (messageWithUuid) {
            case final ScheduledTaskRequest scheduledTask -> scheduledTaskProcessor.processTask(scheduledTask);
            default -> throw new IllegalStateException("Unhandled task type");
        };

        producer.send(taskReplyQueue, taskReply);
        log.info("Sent a reply for task uuid: {}", taskReply.getUuid());
    }
}
