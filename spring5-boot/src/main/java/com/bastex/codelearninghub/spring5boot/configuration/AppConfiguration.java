package com.bastex.codelearninghub.spring5boot.configuration;

import com.bastex.codelearninghub.spring5boot.beans.InitializedInConfigurationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    /**
     * By the default method name becomes Spring Beane name unless specified directly in the annotation as in the example below
     */
    @Bean(name = "beanInitializedInConfiguration")
    InitializedInConfigurationBean beanInitializedInConfigurationSample() {
        return new InitializedInConfigurationBean();
    }
}
