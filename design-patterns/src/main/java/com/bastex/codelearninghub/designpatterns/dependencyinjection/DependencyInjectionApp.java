package com.bastex.codelearninghub.designpatterns.dependencyinjection;


import com.bastex.codelearninghub.designpatterns.dependencyinjection.controllers.ConstructorInjectedController;
import com.bastex.codelearninghub.designpatterns.dependencyinjection.controllers.PropertyInjectedController;
import com.bastex.codelearninghub.designpatterns.dependencyinjection.controllers.SetterInjectedController;
import com.bastex.codelearninghub.designpatterns.dependencyinjection.services.MathServiceImpl;
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
        propertyInjectedController.mathService = new MathServiceImpl();
        propertyInjectedController.multiply(2, 3);

        // Setter DI - less recommended approach
        final SetterInjectedController setterInjectedController = new SetterInjectedController();
        setterInjectedController.setMathService(new MathServiceImpl());

        setterInjectedController.multiply(2, 3);

        // Constructor DI - recommended - best way to use DI
        final ConstructorInjectedController constructorInjectedController = new ConstructorInjectedController(new MathServiceImpl());
        constructorInjectedController.multiply(2, 3);
    }
}
