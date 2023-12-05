package com.bastex.codelearninghub.spring.context.scopes;

import com.bastex.codelearninghub.spring.context.scopes.model.User;
import com.bastex.codelearninghub.spring.context.scopes.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@SpringBootApplication
public class SpringContextScopesApp {
    public static void main(final String[] args) {
        try (final ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringContextScopesApp.class, args)) {
            final UserService userService = applicationContext.getBean(UserService.class);

            // new user is created each time we ask for User object because of prototype type
            final User user = applicationContext.getBean(User.class);
            user.setEmail("john.smith@gmail.com");
            user.setUsername("john345");
            userService.registerUser(user);

            final User user2 = applicationContext.getBean(User.class);
            log.info("New user prototype: {}", user2);
            user2.setEmail("paul.jones@gmail.com");
            user.setUsername("paulj74");
            userService.registerUser(user2);

            // Here we get the same instance as userService because of singleton scope
            final UserService userService2 = applicationContext.getBean(UserService.class);
            userService2.logUsers();
        }
    }
}
