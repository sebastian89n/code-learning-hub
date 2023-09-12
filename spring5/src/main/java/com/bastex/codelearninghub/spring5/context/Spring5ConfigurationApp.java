package com.bastex.codelearninghub.spring5.context;

import com.bastex.codelearninghub.spring5.context.configuration.Spring5CoreConfiguration;
import com.bastex.codelearninghub.spring5.context.configuration.services.ConfigurationInitializedBeanService;
import com.bastex.codelearninghub.spring5.context.configuration.services.PetService;
import com.bastex.codelearninghub.spring5.context.services.I18nService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Spring5ConfigurationApp {
    public static void main(final String[] args) {
        // Annotation config example by loading context with AnnotationConfigApplicationContext by specifying @Configuration class
        // Allows to use Spring core with dependency injection and IoC(Inversion of Control -> beans are initialized by runtime env/framework) by loading @Configuration class

        final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(Spring5CoreConfiguration.class);

        // or pass via VM params -Dspring.profiles.active=cat
        applicationContext.getEnvironment().setActiveProfiles("cat");
        applicationContext.refresh();

        final ConfigurationInitializedBeanService beanService = applicationContext.getBean(ConfigurationInitializedBeanService.class);
        beanService.printComponentType();

        final I18nService i18nService = applicationContext.getBean(I18nService.class);// gets primary bean because no name is specified
        log.info(i18nService.getGreeting());

        final I18nService i18nEsService = applicationContext.getBean("i18nEsService", I18nService.class); // gets bean by name
        log.info(i18nEsService.getGreeting());

        final PetService petService = applicationContext.getBean(PetService.class); // uses profile to pick up right implementation
        log.info(petService.getFavouritePet());
    }
}
