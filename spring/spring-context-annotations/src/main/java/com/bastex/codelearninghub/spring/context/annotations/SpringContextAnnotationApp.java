package com.bastex.codelearninghub.spring.context.annotations;

import com.bastex.codelearninghub.spring.context.annotations.services.AnnotationInitializedBeanService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringContextAnnotationApp {
    public static void main(final String[] args) {
        // Annotation config example by loading context with AnnotationConfigApplicationContext by specifying @Configuration class
        // Spring5CoreAnnotationConfiguration uses @ComponentScan to find beans annotated with Spring annotations like @Component, @Service, @Repository etc
        final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringContextAnnotationConfiguration.class);

        final AnnotationInitializedBeanService beanService = applicationContext.getBean(AnnotationInitializedBeanService.class);
        beanService.printComponentType();
    }
}
