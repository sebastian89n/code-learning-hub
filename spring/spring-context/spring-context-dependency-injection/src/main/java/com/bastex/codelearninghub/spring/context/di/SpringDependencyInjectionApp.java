package com.bastex.codelearninghub.spring.context.di;

import com.bastex.codelearninghub.spring.context.di.controllers.di.ConstructorInjectedController;
import com.bastex.codelearninghub.spring.context.di.controllers.di.PropertyInjectedController;
import com.bastex.codelearninghub.spring.context.di.controllers.di.SetterInjectedController;
import com.bastex.codelearninghub.spring.context.di.controllers.primary.PrimaryBeanInjectedController;
import com.bastex.codelearninghub.spring.context.di.services.GreetingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@Slf4j
public class SpringDependencyInjectionApp {
    public static void main(final String[] args) {
        try (final ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringDependencyInjectionApp.class, args)) {
            // We need to specify bean name because there are 3 implementations of GreetingBootService
            final GreetingService helloBootService = applicationContext.getBean("constructorGreetingService", GreetingService.class);
            helloBootService.sayGreeting();

            // Otherwise we could just do this:
            // final GreetingBootService helloBootService = applicationContext.getBean(GreetingBootService.class);

            log.info("---- Property DI - not recommended -----");
            final PropertyInjectedController propertyInjectedController = applicationContext.getBean(PropertyInjectedController.class);
            log.info(propertyInjectedController.getGreeting());

            log.info("---- Setter DI - not recommended -----");
            final SetterInjectedController setterInjectedController = applicationContext.getBean(SetterInjectedController.class);
            log.info(setterInjectedController.getGreeting());

            log.info("---- Constructor DI - recommended -----");
            final ConstructorInjectedController constructorInjectedController = applicationContext.getBean(ConstructorInjectedController.class);
            log.info(constructorInjectedController.getGreeting());

            log.info("---- Primary bean DI -----");
            final PrimaryBeanInjectedController primaryBeanInjectedController = applicationContext.getBean(PrimaryBeanInjectedController.class);
            log.info(primaryBeanInjectedController.getGreeting());
        }
    }
}
