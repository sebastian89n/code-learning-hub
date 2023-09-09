package com.bastex.codelearninghub.spring5core.configuration;

import com.bastex.codelearninghub.spring5core.configuration.services.ConfigurationInitializedBeanService;
import com.bastex.codelearninghub.spring5core.configuration.services.ConfigurationInitializedBeanServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Spring5CoreConfiguration {
    @Bean(name = "beanService")
    ConfigurationInitializedBeanService configurationInitializedBeanService() {
        return new ConfigurationInitializedBeanServiceImpl();
    }
}
