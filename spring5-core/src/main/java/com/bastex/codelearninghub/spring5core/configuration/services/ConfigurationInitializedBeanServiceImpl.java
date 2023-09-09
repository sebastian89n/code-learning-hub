package com.bastex.codelearninghub.spring5core.configuration.services;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConfigurationInitializedBeanServiceImpl implements ConfigurationInitializedBeanService {
    @Override
    public void printComponentName() {
        log.info("Component name: {}", this.getClass().getSimpleName());
    }
}
