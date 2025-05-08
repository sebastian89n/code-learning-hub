package com.bastex.codelearninghub.spring.context.di.services.di;

import com.bastex.codelearninghub.spring.context.di.services.GreetingService;
import org.springframework.stereotype.Service;

/**
 * By the default Spring bean name is class name with first letter lowercase: propertyInjectedGreetingBootService
 */
@Service
class PropertyInjectedGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Property: Hello World!";
    }
}
