package com.bastex.codelearninghub.spring.context.configuration;

import com.bastex.codelearninghub.spring.context.configuration.services.DiscountService;
import com.bastex.codelearninghub.spring.context.configuration.services.DiscountServiceImpl;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

@Configuration
public class DiscountServicesConfiguration {
    @Bean(name = "discountService") // bean name overridden
    @Profile("discount")
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    DiscountService discountService() {
        return new DiscountServiceImpl(0.9);
    }
}
