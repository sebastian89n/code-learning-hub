package com.bastex.codelearninghub.spring5.context.configuration.services;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConfigurationInitializedBeanServiceImpl implements ConfigurationInitializedBeanService {
    @Override
    public void printComponentType() {
        log.info("Component type: {}", this.getClass().getSimpleName());
    }
}
