package com.bastex.codelearninghub.spring5.context.configuration;

import com.bastex.codelearninghub.spring5.context.configuration.services.*;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Bean(name = "i18nEnService") // bean name is specified manually
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
        return new DogServiceImpl(i18nEsService()); // directly injecting bean impl. Spanish i18nService hardcoded here.
    }

    @Bean(name = "petService")
    @Profile("cat")
    PetService catService(@Qualifier("i18nEsService") final I18nService i18nService) { // Spring will inject arguments from the context. @Qualifier to specify what bean name
        return new CatServiceImpl(i18nService);
    }
}
