package com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.notifications;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class NotificationMessage implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String taskUuid;

    private String notification;
}
