package com.bastex.codelearninghub.java.newfeatures.java17.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private String firstName;

    private String lastName;

    private double baseSalary;
}
