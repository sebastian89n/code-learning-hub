package com.bastex.codelearninghub.java.newfeatures.java17.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
