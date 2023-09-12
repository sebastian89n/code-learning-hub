package com.bastex.codelearninghub.spring5.context.configuration;

import com.bastex.codelearninghub.spring5.context.configuration.services.*;
import com.bastex.codelearninghub.spring5.context.services.I18nEnServiceImpl;
import com.bastex.codelearninghub.spring5.context.services.I18nEsServiceImpl;
import com.bastex.codelearninghub.spring5.context.services.I18nService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

@Configuration
public class Spring5CoreConfiguration {
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
        // prototype scope, new bean is created in every place where it is injected. By the default singleton if scope is not specified.
    ConfigurationInitializedPrototypeBean configurationInitializedBean() {
        return new ConfigurationInitializedPrototypeBeanImpl();
    }

    @Bean(name = "i18nEnService") // bean name is specified manually
    @Primary
        // we have multiple interface implementations in the context. This one will be used if no bean name is specified when getting bean from the context
    I18nService i18nEnService() {
        return new I18nEnServiceImpl();
    }

    // bean name taken from method name
    @Bean
    I18nService i18nEsService() {
        return new I18nEsServiceImpl();
    }

    @Bean(name = "petService")
    @Profile({"default", "dog"})
    PetService dogService() {
        return new DogServiceImpl(i18nEsService()); // Spring calls proxy method that provides bean instance. Spanish i18nService hardcoded here
    }

    @Bean(name = "petService")
    @Profile("cat")
    PetService catService(@Qualifier("i18nEsService") final I18nService i18nService) { // Spring will inject arguments from the context. @Qualifier to specify what bean name
        return new CatServiceImpl(i18nService);
    }
}
