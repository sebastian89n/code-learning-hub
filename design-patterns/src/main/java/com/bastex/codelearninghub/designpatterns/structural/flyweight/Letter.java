package com.bastex.codelearninghub.designpatterns.structural.flyweight;


import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Letter {
    @Getter
    private final String value;

    public Letter(final String value) {
        log.info("New letter created with value: {}", value);
        this.value = value;
    }
}
