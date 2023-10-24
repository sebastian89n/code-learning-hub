package com.bastex.codelearninghub.java.jaxp.model.students;

import lombok.Data;

import java.time.LocalDate;

@Data
public final class Student {
    private String firstName;

    private String lastName;

    private LocalDate birthDate;
}
