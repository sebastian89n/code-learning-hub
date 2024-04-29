package com.bastex.codelearninghub.spring.context.di.controllers.di;

import com.bastex.codelearninghub.spring.context.di.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class SetterInjectedController {
    private GreetingService greetingService;

    public String getGreeting() {
        return greetingService.sayGreeting();
    }

    @Autowired
    @Qualifier("setterGreetingService")
    void setGreetingBootService(final GreetingService greetingService) {
        this.greetingService = greetingService;
    }
}
