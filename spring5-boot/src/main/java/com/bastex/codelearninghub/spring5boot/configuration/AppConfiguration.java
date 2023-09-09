package com.bastex.codelearninghub.spring5boot.configuration;

import com.bastex.codelearninghub.spring5boot.beans.BeanInitializedInConfigurationSample;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    @Bean(name = "beanInitializedInConfiguration")
    BeanInitializedInConfigurationSample beanInitializedInConfigurationSample() {
        return new BeanInitializedInConfigurationSample();
    }
}
