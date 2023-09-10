package com.bastex.codelearninghub.spring5.boot.controllers.di;

import com.bastex.codelearninghub.spring5.boot.services.GreetingBootService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class ConstructorInjectedBootController {
    private final GreetingBootService constructorGreetingService;

    /**
     * Adding Autowired on constructor is optional, if there's only one constructor
     */
    public ConstructorInjectedBootController(final @Qualifier("constructorGreetingService") GreetingBootService constructorGreetingService) {
        this.constructorGreetingService = constructorGreetingService;
    }

    public String getGreeting() {
        return constructorGreetingService.sayGreeting();
    }
}