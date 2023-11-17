package com.bastex.codelearninghub.jakartaee.jms.taskmanager.server.processors;

import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.tasks.requests.ScheduledTaskRequest;
import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.tasks.responses.TaskReply;
import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.tasks.responses.TaskStatusType;

public class ScheduledTaskProcessor implements TaskProcessor<ScheduledTaskRequest> {
    @Override
    public TaskReply processTask(final ScheduledTaskRequest task) {
        // some complex logic
        return TaskReply.builder()
                .taskUuid(task.getTaskUuid())
                .status(TaskStatusType.SUCCESS)
                .build();
    }
}
