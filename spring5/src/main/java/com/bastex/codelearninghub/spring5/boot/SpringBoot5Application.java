package com.bastex.codelearninghub.spring5.boot;

import com.bastex.codelearninghub.spring5.boot.controllers.di.ConstructorInjectedBootController;
import com.bastex.codelearninghub.spring5.boot.controllers.di.PropertyInjectedBootController;
import com.bastex.codelearninghub.spring5.boot.controllers.di.SetterInjectedBootController;
import com.bastex.codelearninghub.spring5.boot.controllers.primary.PrimaryBeanInjectedController;
import com.bastex.codelearninghub.spring5.boot.controllers.profiles.I18nController;
import com.bastex.codelearninghub.spring5.boot.controllers.profiles.PetController;
import com.bastex.codelearninghub.spring5.boot.services.GreetingBootService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

// by default executes @ComponentScan on all beans within the same package recursively + acts as @Configuration class - @Bean can be specified here
// open @SpringBootApplication definition for details
// scanBasePackages can override default packages to scan. By the default it scans only classes within same package as class with @SpringBootApplication anno(recursively)
@SpringBootApplication(scanBasePackages = {"com.bastex.codelearninghub.spring5.boot", "com.bastex.codelearninghub.spring5.context.annotations"})
@Slf4j
public class SpringBoot5Application {

    public static void main(final String[] args) {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBoot5Application.class, args);

        dependencyInjectionExamples(applicationContext);
        profilesExamples(applicationContext);
    }

    private static void dependencyInjectionExamples(final ConfigurableApplicationContext applicationContext) {
        // We need to specify bean name because there are 3 implementations of GreetingBootService
        final GreetingBootService helloBootService = applicationContext.getBean("constructorGreetingService", GreetingBootService.class);
        helloBootService.sayGreeting();

        // Otherwise we could just do this:
        // final GreetingBootService helloBootService = applicationContext.getBean(GreetingBootService.class);

        System.out.println("---- Property DI - not recommended -----");
        final PropertyInjectedBootController propertyInjectedBootController = applicationContext.getBean(PropertyInjectedBootController.class);
        System.out.println(propertyInjectedBootController.getGreeting());

        System.out.println("---- Setter DI - not recommended -----");
        final SetterInjectedBootController setterInjectedBootController = applicationContext.getBean(SetterInjectedBootController.class);
        System.out.println(setterInjectedBootController.getGreeting());

        System.out.println("---- Constructor DI - recommended -----");
        final ConstructorInjectedBootController constructorInjectedBootController = applicationContext.getBean(ConstructorInjectedBootController.class);
        System.out.println(constructorInjectedBootController.getGreeting());

        System.out.println("---- Primary bean DI -----");
        final PrimaryBeanInjectedController primaryBeanInjectedController = applicationContext.getBean(PrimaryBeanInjectedController.class);
        System.out.println(primaryBeanInjectedController.getGreeting());
    }

    private static void profilesExamples(final ConfigurableApplicationContext applicationContext) {
        // Using profiles (defined in application.properties)
        final I18nController i18nController = applicationContext.getBean(I18nController.class);
        System.out.println(i18nController.getLocalizedGreeting());

        final PetController petController = applicationContext.getBean(PetController.class);
        System.out.println(petController.sayFavouritePetType());
    }

    /**
     * We can initialize beans manually by using @Bean annotation in @Configuration classes.
     * It can be done also here because @SpringBootApplication has @Configuration inside.
     * By the default method name becomes a name of the bean -> beanInitializedInConfigurationSample
     * However it can be overridden using name attribute ->beanInitializedInConfiguration
     */
//    @Bean(name = "beanInitializedInConfiguration")
//    BeanInitializedInConfigurationSample beanInitializedInConfigurationSample() {
//        return new BeanInitializedInConfigurationSample();
//    }
}
