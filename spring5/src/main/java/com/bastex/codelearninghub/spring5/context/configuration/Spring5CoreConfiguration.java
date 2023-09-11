package com.bastex.codelearninghub.spring5.context.configuration;

import com.bastex.codelearninghub.spring5.context.configuration.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class Spring5CoreConfiguration {
    // here method name becomes the name of the Bean inside the context
    @Bean
    ConfigurationInitializedBeanService configurationInitializedBeanService() {
        return new ConfigurationInitializedBeanServiceImpl();
    }

    @Bean(name = "i18nEnService") // here bean name is specified manually
    @Primary
        // we have multiple interface implementations in the context. This one will be used if no bean name is specified when getting bean from the context
    I18nService i18nEnService() {
        return new I18nEnServiceImpl();
    }

    @Bean(name = "i18nEsService")
    I18nService i18nEsService() {
        return new I18nEsServiceImpl();
    }

    @Bean(name = "petService")
    @Profile({"default", "dog"})
    PetService dogService() {
        return new DogServiceImpl();
    }

    @Bean(name = "petService")
    @Profile("cat")
    PetService catService() {
        return new CatServiceImpl();
    }
}
