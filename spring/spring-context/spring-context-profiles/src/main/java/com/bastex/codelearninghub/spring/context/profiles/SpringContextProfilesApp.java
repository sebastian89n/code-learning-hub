package com.bastex.codelearninghub.spring.context.profiles;

import com.bastex.codelearninghub.spring.context.profiles.services.I18nService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@SpringBootApplication
public class SpringContextProfilesApp {
    public static void main(final String[] args) {
        try (final ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringContextProfilesApp.class, args)) {
            final I18nService i18nService = applicationContext.getBean(I18nService.class);
            log.info("Using {} locale", i18nService.getLocale());
            log.info(i18nService.getGreeting());
        }
    }
}
