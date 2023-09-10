package com.bastex.codelearninghub.spring5.boot.services.di;

import com.bastex.codelearninghub.spring5.boot.services.GreetingBootService;
import org.springframework.stereotype.Service;

@Service("constructorGreetingService") // specifying bean name directly
class ConstructorInjectedGreetingBootService implements GreetingBootService {
    @Override
    public String sayGreeting() {
        return "Constructor: Hello World!";
    }
}
