package com.bastex.codelearninghub.spring.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.bastex.codelearninghub.spring.mvc",
        "com.bastex.codelearninghub.spring.data"})
public class SpringMvcApp {
    public static void main(final String[] args) {
        SpringApplication.run(SpringMvcApp.class, args);
    }
}
