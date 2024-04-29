package com.bastex.codelearninghub.spring.context.di.controllers.di;

import com.bastex.codelearninghub.spring.context.di.services.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class ConstructorInjectedController {
    private final GreetingService constructorGreetingService;

    /**
     * Adding @Autowired on constructor is optional, if there's only one constructor
     */
    public ConstructorInjectedController(final @Qualifier("constructorGreetingService") GreetingService constructorGreetingService) {
        this.constructorGreetingService = constructorGreetingService;
    }

    public String getGreeting() {
        return constructorGreetingService.sayGreeting();
    }
}
