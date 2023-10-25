package com.bastex.codelearninghub.java.jaxp.model.students;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class Student {
    private String id;

    private String firstName;

    private String lastName;

    private LocalDate birthDate;
}
