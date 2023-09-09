package com.bastex.codelearninghub.spring5core;

import com.bastex.codelearninghub.spring5core.configuration.AppConfiguration;
import com.bastex.codelearninghub.spring5core.services.BeanService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Spring5CoreApp {
    public static void main(final String[] args) {
        // Annotation config example by loading context with AnnotationConfigApplicationContext by specifying @Configuration class
        // Allows to use Spring core with dependency injection and IoC(Inversion of Control -> beans are initialized by runtime env/framework) by loading @Configuration class
        final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);

        final BeanService beanService = applicationContext.getBean(BeanService.class);
        beanService.printComponentName();
    }
}
