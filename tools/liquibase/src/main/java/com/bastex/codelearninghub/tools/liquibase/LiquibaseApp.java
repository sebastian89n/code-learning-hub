package com.bastex.codelearninghub.tools.liquibase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LiquibaseApp {
    public static void main(final String[] args) throws InterruptedException {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(LiquibaseApp.class);
        AppContext.INSTANCE.setApplicationContext(applicationContext);

        Thread.currentThread().join();
    }
}
