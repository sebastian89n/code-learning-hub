package com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.tasks.requests;

import java.io.Serializable;

public sealed interface TaskRequest extends Serializable permits ScheduledTaskRequest {
    String getTaskUuid();

    TaskType getTaskType();
}
