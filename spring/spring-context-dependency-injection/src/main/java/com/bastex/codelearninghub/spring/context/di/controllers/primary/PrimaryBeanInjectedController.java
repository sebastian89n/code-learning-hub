package com.bastex.codelearninghub.spring.context.di.controllers.primary;

import com.bastex.codelearninghub.spring.context.di.services.GreetingBootService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

/**
 * No proper bean name specified in the name or @Qualifier, but we have @Primary bean that will be used in this case
 */
@Controller
@RequiredArgsConstructor
public class PrimaryBeanInjectedController {
    private final GreetingBootService greetingService;

    public String getGreeting() {
        return greetingService.sayGreeting();
    }
}
