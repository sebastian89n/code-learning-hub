package com.bastex.codelearninghub.spring.jms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringJmsApp {
    public static void main(String[] args) {
        try (ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringJmsApp.class, args)) {
            
        }
    }
}
