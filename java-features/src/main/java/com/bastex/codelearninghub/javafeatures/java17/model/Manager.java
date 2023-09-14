package com.bastex.codelearninghub.javafeatures.java17.model;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
public class Manager extends Employee {
    private double bonusSalary;

    public Manager(final String firstName, final String lastName, final double baseSalary, final double bonusSalary) {
        super(firstName, lastName, baseSalary);
        this.bonusSalary = bonusSalary;
    }
}
