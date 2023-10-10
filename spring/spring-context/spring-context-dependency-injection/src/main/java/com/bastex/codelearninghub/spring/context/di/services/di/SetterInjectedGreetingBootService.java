package com.bastex.codelearninghub.spring.context.di.services.di;

import com.bastex.codelearninghub.spring.context.di.services.GreetingBootService;
import org.springframework.stereotype.Service;

@Service("setterGreetingService") // specifying bean name directly
class SetterInjectedGreetingBootService implements GreetingBootService {
    @Override
    public String sayGreeting() {
        return "Setter: Hello World!";
    }
}
