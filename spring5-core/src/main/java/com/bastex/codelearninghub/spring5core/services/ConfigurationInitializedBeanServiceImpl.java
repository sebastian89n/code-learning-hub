package com.bastex.codelearninghub.spring5core.services;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConfigurationInitializedBeanServiceImpl implements BeanService {
    @Override
    public void printComponentName() {
        log.info("Component name: ConfigurationInitializedBeanServiceImpl");
    }
}
