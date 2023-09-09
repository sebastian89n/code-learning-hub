package com.bastex.codelearninghub.spring5core.configuration;

import com.bastex.codelearninghub.spring5core.services.BeanService;
import com.bastex.codelearninghub.spring5core.services.ConfigurationInitializedBeanServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    @Bean
    BeanService configurationInitializedBeanService() {
        return new ConfigurationInitializedBeanServiceImpl();
    }
}
