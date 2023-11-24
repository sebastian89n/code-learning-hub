package com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.tasks.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class TaskReply implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String taskUuid;

    private TaskStatusType status;
}