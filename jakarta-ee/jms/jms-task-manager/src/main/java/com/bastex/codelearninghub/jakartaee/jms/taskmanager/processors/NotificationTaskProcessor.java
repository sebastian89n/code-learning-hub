package com.bastex.codelearninghub.jakartaee.jms.taskmanager.processors;

import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.requests.NotificationTask;
import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.responses.TaskReply;
import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.responses.TaskStatusType;

public class NotificationTaskProcessor implements TaskProcessor<NotificationTask> {
    @Override
    public TaskReply processTask(final NotificationTask task) {
        // some complex logic
        return TaskReply.builder()
                .taskUuid(task.getTaskUuid())
                .status(TaskStatusType.SUCCESS)
                .build();
    }
}
