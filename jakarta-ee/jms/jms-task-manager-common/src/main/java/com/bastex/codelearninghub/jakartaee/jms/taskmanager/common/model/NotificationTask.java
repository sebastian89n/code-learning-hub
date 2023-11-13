package com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model;

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

    private Long taskId;

    private TaskType taskType;

    private String notification;
}
