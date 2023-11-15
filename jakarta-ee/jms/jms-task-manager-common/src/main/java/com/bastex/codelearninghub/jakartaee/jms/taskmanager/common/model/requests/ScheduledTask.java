package com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class ScheduledTask implements Task {
    @Serial
    private static final long serialVersionUID = 1L;

    private String taskUuid;

    private String description;

    private LocalDate scheduledAt;

    @Override
    public TaskType getTaskType() {
        return TaskType.SCHEDULED_TASK;
    }
}
