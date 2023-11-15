package com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class TaskReply implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long taskUuid;

    private TaskStatusType status;
}
