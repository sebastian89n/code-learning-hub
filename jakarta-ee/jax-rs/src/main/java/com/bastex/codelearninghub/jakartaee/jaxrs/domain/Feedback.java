package com.bastex.codelearninghub.jakartaee.jaxrs.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {
    private Long id;

    private String text;

    private String userId;

    private Instant created;
}
