package com.bastex.codelearninghub.spring.context.configuration;

import com.bastex.codelearninghub.spring.context.configuration.services.CatServiceImpl;
import com.bastex.codelearninghub.spring.context.configuration.services.DogServiceImpl;
import com.bastex.codelearninghub.spring.context.configuration.services.I18nService;
import com.bastex.codelearninghub.spring.context.configuration.services.PetService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

@Configuration
@Import(LocalizationConfiguration.class)
public class MainBeansConfiguration {
    @Bean(name = "petService")
    PetService dogService(@Qualifier("i18nEsService") final I18nService i18nService) {
        return new DogServiceImpl(i18nService);
    }

    @Bean(name = "petService")
    @Profile("cat")
    PetService catService(@Qualifier("i18nEsService") final I18nService i18nService) {
        return new CatServiceImpl(i18nService);
    }
}
