package com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.tasks.responses;

import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.common.MessageWithUuid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class TaskReply implements MessageWithUuid {
    @Serial
    private static final long serialVersionUID = 1L;

    private String uuid;

    private Status status;

    public enum Status {
        SUCCESS, ERROR
    }
}
