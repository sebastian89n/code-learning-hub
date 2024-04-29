package com.bastex.codelearninghub.spring.context.di.services.di;

import com.bastex.codelearninghub.spring.context.di.services.GreetingService;
import org.springframework.stereotype.Service;

@Service("setterGreetingService") // specifying bean name directly
class SetterInjectedGreetingBootService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Setter: Hello World!";
    }
}
