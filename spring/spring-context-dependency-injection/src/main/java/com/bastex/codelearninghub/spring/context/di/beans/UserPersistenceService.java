package com.bastex.codelearninghub.spring.context.di.beans;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;

/**
 * Sample for bean initialized in the @Configuration class using @Bean annotation.
 * Just another way to create Spring beans.
 */
@Slf4j
public class UserPersistenceService {
    @PostConstruct
    public void init() {
        log.info("### {} @PostConstruct", this.getClass().getSimpleName());
    }
}
