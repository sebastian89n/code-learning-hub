package com.bastex.codelearninghub.spring.aop;

import com.bastex.codelearninghub.spring.aop.services.MathService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@Slf4j
public class SpringAopApp {
    public static void main(final String[] args) {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringAopApp.class);
        final MathService mathService = applicationContext.getBean(MathService.class);

        mathService.add(5, 8);

        mathService.subtract(8, 5);
        mathService.subtractFromHighest(4, 8);

        mathService.multiply(3, 3);
        mathService.multiplyChain(3, 3, 3, 3);

        try {
            mathService.add(null, 5);
        } catch (final NullPointerException e) {
            log.warn("NullPointerException was thrown in method on purpose and stack has been intercepted using Aspect");
        }
    }
}
