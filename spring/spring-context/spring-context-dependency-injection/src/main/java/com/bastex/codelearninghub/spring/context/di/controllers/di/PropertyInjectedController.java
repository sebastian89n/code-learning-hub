package com.bastex.codelearninghub.spring.context.di.controllers.di;

import com.bastex.codelearninghub.spring.context.di.services.GreetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class PropertyInjectedController {
    @Autowired
    @Qualifier("propertyInjectedGreetingService")
    private GreetingService greetingService;

    public String getGreeting() {
        return greetingService.sayGreeting();
    }
}
