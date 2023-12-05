package com.bastex.codelearninghub.spring.context.profiles;

import com.bastex.codelearninghub.spring.context.profiles.services.I18nEnServiceImpl;
import com.bastex.codelearninghub.spring.context.profiles.services.I18nEsServiceImpl;
import com.bastex.codelearninghub.spring.context.profiles.services.I18nService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ProfilesConfiguration {
    @Bean(name = "i18nEnService")
    @Profile({"default", "en"})
    I18nService i18nEnService() {
        return new I18nEnServiceImpl();
    }

    @Bean
    @Profile("es")
    I18nService i18nEsService() {
        return new I18nEsServiceImpl();
    }
}
