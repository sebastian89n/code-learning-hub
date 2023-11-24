package com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.tasks.requests;

import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.common.MessageWithUuid;

public sealed interface TaskRequest extends MessageWithUuid permits ScheduledTaskRequest {
    @Override
    String getUuid();

    TaskType getTaskType();
}
