package com.bastex.codelearninghub.spring5.boot.configuration;

import com.bastex.codelearninghub.spring5.boot.beans.UserPersistenceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    /**
     * By the default method name becomes Spring Bean in the context unless specified directly in the annotation as in the example below
     */
    @Bean(name = "beanInitializedInConfiguration")
    UserPersistenceService userPersistenceService() {
        return new UserPersistenceService();
    }
}
