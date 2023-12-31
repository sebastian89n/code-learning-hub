package com.bastex.codelearninghub.java.libs.junitwithmockito.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;

    private String email;

    private String firstName;

    private String lastName;
}
