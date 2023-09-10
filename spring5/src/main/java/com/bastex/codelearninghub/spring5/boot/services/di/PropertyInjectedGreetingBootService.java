package com.bastex.codelearninghub.spring5.boot.services.di;

import com.bastex.codelearninghub.spring5.boot.services.GreetingBootService;
import org.springframework.stereotype.Service;

/**
 * By default Spring bean name is class name with first letter lowercase: propertyInjectedGreetingBootService
 */
@Service
class PropertyInjectedGreetingBootService implements GreetingBootService {
    @Override
    public String sayGreeting() {
        return "Property: Hello World!";
    }
}
