package com.bastex.codelearninghub.spring.context.configuration.services;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConfigurationInitializedPrototypeBeanImpl implements ConfigurationInitializedPrototypeBean {
    @Override
    public void printComponentType() {
        log.info("Component type: {}", this.getClass().getSimpleName());
    }
}
