package com.bastex.codelearninghub.spring.aop;

import com.bastex.codelearninghub.spring.aop.service.MathService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringAopApp {
    public static void main(final String[] args) {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringAopApp.class);
        final MathService mathService = applicationContext.getBean(MathService.class);

        mathService.add(5, 8);

        mathService.subtract(8, 5);
        mathService.subtractFromHighest(4, 8);

        mathService.multiply(3, 3);
        mathService.multiplyChain(3, 3, 3, 3);

        mathService.add(null, 5);
    }
}
