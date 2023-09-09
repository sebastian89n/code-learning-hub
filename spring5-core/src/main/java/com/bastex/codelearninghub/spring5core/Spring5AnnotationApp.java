package com.bastex.codelearninghub.spring5core;

import com.bastex.codelearninghub.spring5core.annotations.Spring5CoreAnnotationConfiguration;
import com.bastex.codelearninghub.spring5core.annotations.services.AnnotationInitializedBeanService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Spring5AnnotationApp {
    public static void main(final String[] args) {
        // Annotation config example by loading context with AnnotationConfigApplicationContext by specifying @Configuration class
        // Spring5CoreAnnotationConfiguration uses @ComponentScan to find beans annotated with Spring annotations like @Component, @Service, @Repository etc
        final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Spring5CoreAnnotationConfiguration.class);

        final AnnotationInitializedBeanService beanService = applicationContext.getBean(AnnotationInitializedBeanService.class);
        beanService.printComponentName();
    }
}
