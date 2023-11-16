package com.bastex.codelearninghub.jakartaee.jms.taskmanager.processors;

import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.requests.ScheduledTask;
import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.responses.TaskReply;
import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.responses.TaskStatusType;

public class ScheduledTaskProcessor implements TaskProcessor<ScheduledTask> {
    @Override
    public TaskReply processTask(final ScheduledTask task) {
        // some complex logic
        return TaskReply.builder()
                .taskUuid(task.getTaskUuid())
                .status(TaskStatusType.SUCCESS)
                .build();
    }
}
