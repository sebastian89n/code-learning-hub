package com.bastex.codelearninghub.testing.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    Long id;

    Instant createdTimestamp;

    Instant updatedTimestamp;

    private String email;

    private String firstName;

    private String lastName;
}
