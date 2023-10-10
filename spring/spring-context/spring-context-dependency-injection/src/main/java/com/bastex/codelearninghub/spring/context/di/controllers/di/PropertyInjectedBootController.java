package com.bastex.codelearninghub.spring.context.di.controllers.di;

import com.bastex.codelearninghub.spring.context.di.services.GreetingBootService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class PropertyInjectedBootController {
    @Autowired
    @Qualifier("propertyInjectedGreetingBootService")
    private GreetingBootService greetingBootService;

    public String getGreeting() {
        return greetingBootService.sayGreeting();
    }
}
