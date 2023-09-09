package com.bastex.codelearninghub.spring5boot.beans;

import jakarta.annotation.PostConstruct;

/**
 * Sample for bean initialized in the @Configuration class using @Bean annotation.
 * Just another way to create Spring beans.
 */
public class BeanInitializedInConfigurationSample {

    @PostConstruct
    public void init() {
        System.out.println("### BeanInitializedInConfigurationSample @PostConstruct");
    }
}
