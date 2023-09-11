package com.bastex.codelearninghub.spring5.context;

import com.bastex.codelearninghub.spring5.context.configuration.Spring5CoreConfiguration;
import com.bastex.codelearninghub.spring5.context.configuration.services.ConfigurationInitializedBeanService;
import com.bastex.codelearninghub.spring5.context.configuration.services.I18nService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Spring5ConfigurationApp {
    public static void main(final String[] args) {
        // Annotation config example by loading context with AnnotationConfigApplicationContext by specifying @Configuration class
        // Allows to use Spring core with dependency injection and IoC(Inversion of Control -> beans are initialized by runtime env/framework) by loading @Configuration class

        // final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Spring5CoreConfiguration.class);
        final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Spring5CoreConfiguration.class);
        applicationContext.register(Spring5CoreConfiguration.class);

        // or via VM params -Dspring.profiles.active=es
        applicationContext.getEnvironment().setActiveProfiles("es");
        applicationContext.refresh();

        final ConfigurationInitializedBeanService beanService = applicationContext.getBean(ConfigurationInitializedBeanService.class);
        beanService.printComponentType();


        final I18nService i18nService = applicationContext.getBean("i18nService", I18nService.class);// bean name specified directly
        log.info(i18nService.getGreeting());
    }
}
