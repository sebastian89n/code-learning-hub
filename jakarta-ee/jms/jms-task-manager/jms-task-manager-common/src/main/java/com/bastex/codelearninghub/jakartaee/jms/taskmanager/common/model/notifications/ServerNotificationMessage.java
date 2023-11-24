package com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.notifications;

import com.bastex.codelearninghub.jakartaee.jms.taskmanager.common.model.common.MessageWithUuid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class ServerNotificationMessage implements MessageWithUuid {
    @Serial
    private static final long serialVersionUID = 1L;

    private String uuid;

    private String notification;
}
