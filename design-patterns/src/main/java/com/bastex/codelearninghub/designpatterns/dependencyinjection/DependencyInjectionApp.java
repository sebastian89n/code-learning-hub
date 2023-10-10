package com.bastex.codelearninghub.designpatterns.dependencyinjection;


import com.bastex.codelearninghub.designpatterns.dependencyinjection.controllers.ConstructorInjectedController;
import com.bastex.codelearninghub.designpatterns.dependencyinjection.controllers.PropertyInjectedController;
import com.bastex.codelearninghub.designpatterns.dependencyinjection.controllers.SetterInjectedController;
import com.bastex.codelearninghub.designpatterns.dependencyinjection.services.DependencyInjectionGreetingServiceImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * Very basic sample of dependency injection without using Spring.
 * Spring core makes it easier for developers by using IoC (Inversion of Control) for DI(Dependency Injection).
 */
@Slf4j
public class DependencyInjectionApp {
    public static void main(final String[] args) {
        // Property DI - not recommended approach
        final PropertyInjectedController propertyInjectedController = new PropertyInjectedController();
        propertyInjectedController.dependencyInjectionGreetingService = new DependencyInjectionGreetingServiceImpl();

        log.info(propertyInjectedController.getGreeting());

        // Setter DI - less recommended approach
        final SetterInjectedController setterInjectedController = new SetterInjectedController();
        setterInjectedController.setDependencyInjectionGreetingService(new DependencyInjectionGreetingServiceImpl());

        log.info(setterInjectedController.getGreeting());

        // Constructor DI - recommended - best way to use DI
        final ConstructorInjectedController constructorInjectedController = new ConstructorInjectedController(new DependencyInjectionGreetingServiceImpl());
        log.info(constructorInjectedController.getGreeting());
    }
}
