package com.bastex.codelearninghub.spring.context.configuration;

import com.bastex.codelearninghub.spring.context.configuration.beans.UserInfo;
import com.bastex.codelearninghub.spring.context.configuration.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class SpringContextAnnotationApp {
    public static void main(final String[] args) {
        // Annotation config example by loading context with AnnotationConfigApplicationContext by specifying @Configuration class
        // SpringContextAnnotationConfiguration uses @ComponentScan to find beans annotated with Spring annotations like @Component, @Service etc
        try (final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringContextAnnotationConfiguration.class)) {
            final UserInfo userInfo = applicationContext.getBean(UserInfo.class);
            userInfo.setFirstName("John");
            userInfo.setLastName("Smith");

            // you can provide specific bean name when getting bean from the context
            final UserService userService = applicationContext.getBean("userService", UserService.class);
            final String fullName = userService.extractFullUserName(userInfo);

            log.info("User full name: {}", fullName);
        }
    }
}
