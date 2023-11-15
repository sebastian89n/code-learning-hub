package com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class NotificationTask implements Task {
    @Serial
    private static final long serialVersionUID = 1L;

    private String taskUuid;

    private String notification;

    @Override
    public TaskType getTaskType() {
        return TaskType.NOTIFICATION_TASK;
    }
}
