package com.bastex.codelearninghub.spring.context.di.services.di;

import com.bastex.codelearninghub.spring.context.di.services.GreetingService;
import org.springframework.stereotype.Service;

@Service("constructorGreetingService") // specifying bean name directly
class ConstructorInjectedGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Constructor: Hello World!";
    }
}
