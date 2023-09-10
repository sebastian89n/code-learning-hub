package com.bastex.codelearninghub.spring5.boot.beans;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

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
