package com.bastex.codelearninghub.spring5.boot.beans;

import jakarta.annotation.PostConstruct;

/**
 * Sample for bean initialized in the @Configuration class using @Bean annotation.
 * Just another way to create Spring beans.
 */
public class UserPersistenceService {
    @PostConstruct
    public void init() {
        System.out.println("### BeanInitializedInConfigurationSample @PostConstruct");
    }
}
