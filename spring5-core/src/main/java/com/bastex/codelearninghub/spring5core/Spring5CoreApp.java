package com.bastex.codelearninghub.spring5core;

import com.bastex.codelearninghub.spring5core.configuration.Spring5CoreConfiguration;
import com.bastex.codelearninghub.spring5core.configuration.services.ConfigurationInitializedBeanService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Spring5CoreApp {
    public static void main(final String[] args) {
        // Annotation config example by loading context with AnnotationConfigApplicationContext by specifying @Configuration class
        // Allows to use Spring core with dependency injection and IoC(Inversion of Control -> beans are initialized by runtime env/framework) by loading @Configuration class
        final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Spring5CoreConfiguration.class);

        final ConfigurationInitializedBeanService beanService = applicationContext.getBean(ConfigurationInitializedBeanService.class);
        beanService.printComponentName();
    }
}
