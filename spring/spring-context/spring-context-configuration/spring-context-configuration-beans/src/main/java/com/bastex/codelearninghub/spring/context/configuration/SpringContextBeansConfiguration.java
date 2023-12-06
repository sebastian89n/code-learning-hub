package com.bastex.codelearninghub.spring.context.configuration;

import com.bastex.codelearninghub.spring.context.configuration.services.ProductService;
import com.bastex.codelearninghub.spring.context.configuration.services.ProductServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DiscountServicesConfiguration.class) // imports another @Configuration class
public class SpringContextBeansConfiguration {
    @Bean
        // By the default method name becomes bean name
    ProductService productService() {
        return new ProductServiceImpl();
    }
}
