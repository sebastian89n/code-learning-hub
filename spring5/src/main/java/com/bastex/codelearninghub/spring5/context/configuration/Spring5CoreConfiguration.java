package com.bastex.codelearninghub.spring5.context.configuration;

import com.bastex.codelearninghub.spring5.context.configuration.services.ConfigurationInitializedBeanService;
import com.bastex.codelearninghub.spring5.context.configuration.services.ConfigurationInitializedBeanServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Spring5CoreConfiguration {
    @Bean(name = "beanService")
    ConfigurationInitializedBeanService configurationInitializedBeanService() {
        return new ConfigurationInitializedBeanServiceImpl();
    }
}
