package com.bastex.codelearninghub.spring5.context.configuration;

import com.bastex.codelearninghub.spring5.context.configuration.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class Spring5CoreConfiguration {
    // here method name becomes the name of the Bean inside the context
    @Bean
    ConfigurationInitializedBeanService configurationInitializedBeanService() {
        return new ConfigurationInitializedBeanServiceImpl();
    }

    @Bean(name = "i18nService") // here bean name is specified manually
    @Profile({"default", "en"})
// and we specify profiles that activates bean
    I18nService i18nEnService() {
        return new I18nEnServiceImpl();
    }

    @Bean(name = "i18nService")
    @Profile("es")
    I18nService i18nEsService() {
        return new I18nEsServiceImpl();
    }
}
