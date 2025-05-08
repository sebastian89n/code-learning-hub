package com.bastex.codelearninghub.spring.jms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationJmsDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String uuid;

    private String notification;

    private Instant generationTimestamp;
}
