package com.bastex.codelearninghub.spring.context.configuration;

import com.bastex.codelearninghub.spring.context.configuration.services.I18nEnServiceImpl;
import com.bastex.codelearninghub.spring.context.configuration.services.I18nEsServiceImpl;
import com.bastex.codelearninghub.spring.context.configuration.services.I18nService;
import com.bastex.codelearninghub.spring.context.configuration.services.TranslationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Configuration
public class LocalizationConfiguration {
    @Bean
    TranslationService translationService() {
        return new TranslationService(List.of(i18nEnService(), i18nEsService()));
    }

    @Bean(name = "i18nEnService") // bean name is specified manually
    @Primary
        // we have multiple interface implementations in the context.
        // Primary bean will be used if no bean name is specified when getting bean from the context
    I18nService i18nEnService() {
        return new I18nEnServiceImpl();
    }

    // No bean name provided in the annotation. Method name becomes bean name
    @Bean
    I18nService i18nEsService() {
        return new I18nEsServiceImpl();
    }
}
