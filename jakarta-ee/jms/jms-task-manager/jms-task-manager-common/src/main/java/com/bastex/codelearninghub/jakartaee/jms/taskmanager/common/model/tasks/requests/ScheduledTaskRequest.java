package com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.tasks.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class ScheduledTaskRequest implements TaskRequest {
    @Serial
    private static final long serialVersionUID = 1L;

    private String uuid;

    private String description;

    private LocalDate scheduledAt;

    @Override
    public TaskType getTaskType() {
        return TaskType.SCHEDULED_TASK;
    }
}
