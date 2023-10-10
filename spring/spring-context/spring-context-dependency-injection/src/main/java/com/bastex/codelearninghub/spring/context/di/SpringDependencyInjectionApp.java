package com.bastex.codelearninghub.spring.context.di;

import com.bastex.codelearninghub.spring.context.di.beans.UserPersistenceService;
import com.bastex.codelearninghub.spring.context.di.controllers.di.ConstructorInjectedBootController;
import com.bastex.codelearninghub.spring.context.di.controllers.di.PropertyInjectedBootController;
import com.bastex.codelearninghub.spring.context.di.controllers.di.SetterInjectedBootController;
import com.bastex.codelearninghub.spring.context.di.controllers.primary.PrimaryBeanInjectedController;
import com.bastex.codelearninghub.spring.context.di.controllers.profiles.I18nController;
import com.bastex.codelearninghub.spring.context.di.controllers.profiles.PetController;
import com.bastex.codelearninghub.spring.context.di.services.GoogleService;
import com.bastex.codelearninghub.spring.context.di.services.GreetingBootService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class SpringDependencyInjectionApp {
    public static void main(final String[] args) {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringDependencyInjectionApp.class, args);
        // We need to specify bean name because there are 3 implementations of GreetingBootService
        final GreetingBootService helloBootService = applicationContext.getBean("constructorGreetingService", GreetingBootService.class);
        helloBootService.sayGreeting();

        // Otherwise we could just do this:
        // final GreetingBootService helloBootService = applicationContext.getBean(GreetingBootService.class);

        log.info("---- Property DI - not recommended -----");
        final PropertyInjectedBootController propertyInjectedBootController = applicationContext.getBean(PropertyInjectedBootController.class);
        log.info(propertyInjectedBootController.getGreeting());

        log.info("---- Setter DI - not recommended -----");
        final SetterInjectedBootController setterInjectedBootController = applicationContext.getBean(SetterInjectedBootController.class);
        log.info(setterInjectedBootController.getGreeting());

        log.info("---- Constructor DI - recommended -----");
        final ConstructorInjectedBootController constructorInjectedBootController = applicationContext.getBean(ConstructorInjectedBootController.class);
        log.info(constructorInjectedBootController.getGreeting());

        log.info("---- Primary bean DI -----");
        final PrimaryBeanInjectedController primaryBeanInjectedController = applicationContext.getBean(PrimaryBeanInjectedController.class);
        log.info(primaryBeanInjectedController.getGreeting());

        final UserPersistenceService userPersistenceService = applicationContext.getBean(UserPersistenceService.class);
        final GoogleService googleService = applicationContext.getBean(GoogleService.class);

        // Using profiles (defined in application.properties)
        final I18nController i18nController = applicationContext.getBean(I18nController.class);
        log.info(i18nController.getLocalizedGreeting());

        final PetController petController = applicationContext.getBean(PetController.class);
        log.info(petController.sayFavouritePetType());
    }

    /**
     * By the default method name becomes Spring Bean in the context unless specified directly in the annotation as in the example below
     */
    @Bean
    UserPersistenceService userPersistenceService() {
        return new UserPersistenceService();
    }

    @Bean
    GoogleService googleService(@Value("${googlecs.url}") final String googleCsUrl) {
        final GoogleService googleService = new GoogleService(googleCsUrl);
        return googleService;
    }
}
