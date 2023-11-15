package com.bastex.codelearninghub.jakartaee.jms.taskmanager.processors;

import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.requests.NotificationTask;
import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.responses.TaskReply;

public class NotificationTaskProcessor implements TaskProcessor<NotificationTask> {
    @Override
    public TaskReply processTask(final NotificationTask task) {
        return null;
    }
}
