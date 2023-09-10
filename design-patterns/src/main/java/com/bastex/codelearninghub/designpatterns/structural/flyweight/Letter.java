package com.bastex.codelearninghub.designpatterns.structural.flyweight;


import lombok.Getter;

public class Letter {
    @Getter
    private final String value;

    public Letter(final String value) {
        System.out.println("New letter created with value: " + value);
        this.value = value;
    }
}
