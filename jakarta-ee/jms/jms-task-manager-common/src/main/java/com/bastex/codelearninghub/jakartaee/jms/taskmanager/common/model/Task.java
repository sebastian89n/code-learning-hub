package com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model;

import java.io.Serializable;

public sealed interface Task extends Serializable permits ScheduledTask, NotificationTask {
    Long getTaskId();

    TaskType getTaskType();
}
