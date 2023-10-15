package com.bastex.codelearninghub.spring.context.di.controllers.di;

import com.bastex.codelearninghub.spring.context.di.services.GreetingBootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class SetterInjectedBootController {
    private GreetingBootService greetingBootService;

    public String getGreeting() {
        return greetingBootService.sayGreeting();
    }

    @Autowired
    @Qualifier("setterGreetingService")
    void setGreetingBootService(final GreetingBootService greetingBootService) {
        this.greetingBootService = greetingBootService;
    }
}