package com.bastex.codelearninghub.spring.context.configuration;

import com.bastex.codelearninghub.spring.context.configuration.services.CatServiceImpl;
import com.bastex.codelearninghub.spring.context.configuration.services.DogServiceImpl;
import com.bastex.codelearninghub.spring.context.configuration.services.I18nService;
import com.bastex.codelearninghub.spring.context.configuration.services.PetService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

@Configuration
@Import(LocalizationConfiguration.class)
public class MainContextConfiguration {
    @Bean(name = "petService")
    @Profile({"default", "dog"})
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
        // prototype scope, new bean is created in every place where it is injected. By the default singleton if scope is not specified.
    PetService dogService(@Qualifier("i18nEsService") final I18nService i18nService) {
        return new DogServiceImpl(i18nService);
    }

    @Bean(name = "petService")
    @Profile("cat")
    PetService catService(@Qualifier("i18nEsService") final I18nService i18nService) { // Spring will inject arguments from the context. @Qualifier to specify what bean name
        return new CatServiceImpl(i18nService);
    }
}
