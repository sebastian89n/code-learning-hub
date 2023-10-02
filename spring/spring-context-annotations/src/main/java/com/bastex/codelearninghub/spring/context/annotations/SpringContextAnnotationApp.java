package com.bastex.codelearninghub.spring.context.annotations;

import com.bastex.codelearninghub.spring.context.annotations.beans.UserInfo;
import com.bastex.codelearninghub.spring.context.annotations.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class SpringContextAnnotationApp {
    public static void main(final String[] args) {
        // Annotation config example by loading context with AnnotationConfigApplicationContext by specifying @Configuration class
        // Spring5CoreAnnotationConfiguration uses @ComponentScan to find beans annotated with Spring annotations like @Component, @Service etc
        final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringContextAnnotationConfiguration.class);

        final UserInfo userInfo = applicationContext.getBean(UserInfo.class);
        userInfo.setFirstName("John");
        userInfo.setLastName("Smith");

        final UserService userService = applicationContext.getBean(UserService.class);
        final String fullName = userService.extractFullUserName(userInfo);

        log.info("User full name: {}", fullName);
    }
}
