package com.bastex.codelearninghub.spring.context.configuration;

import com.bastex.codelearninghub.spring.context.configuration.services.I18nService;
import com.bastex.codelearninghub.spring.context.configuration.services.PetService;
import com.bastex.codelearninghub.spring.context.configuration.services.TranslationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Locale;

@Slf4j
public class SpringContextConfigurationApp {
    public static void main(final String[] args) {
        // Annotation config example by loading context with AnnotationConfigApplicationContext by specifying @Configuration class
        // Allows to use Spring core with dependency injection and IoC(Inversion of Control -> beans are initialized by runtime env/framework) by loading @Configuration class
        try (final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext()) {
            applicationContext.register(MainContextConfiguration.class);

            // or pass via VM params -Dspring.profiles.active=cat
            applicationContext.getEnvironment().setActiveProfiles("cat");
            applicationContext.refresh();

            final I18nService i18nService = applicationContext.getBean(I18nService.class);// gets primary bean because no name is specified
            log.info(i18nService.getGreeting());

            final I18nService i18nEsService = applicationContext.getBean("i18nEsService", I18nService.class); // get bean by name and type
            log.info(i18nEsService.getGreeting());

            final PetService petService = applicationContext.getBean(PetService.class); // uses profile to pick up right implementation
            log.info(petService.callAnimal());

            final TranslationService beanService = applicationContext.getBean(TranslationService.class);
            final String greeting = beanService.prepareUserGreetingInLocale("John", new Locale("es"));
            log.info(greeting);
        }
    }
}
