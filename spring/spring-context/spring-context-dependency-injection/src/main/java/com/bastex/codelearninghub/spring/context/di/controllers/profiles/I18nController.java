package com.bastex.codelearninghub.spring.context.di.controllers.profiles;

import com.bastex.codelearninghub.spring.context.di.services.GreetingBootService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * There are 2 beans named as i18nService. Which one is injected is determined by the profile
 */
@Controller
public class I18nController {
    private final GreetingBootService greetingBootService;

    public I18nController(final @Qualifier("i18nService") GreetingBootService greetingBootService) {
        this.greetingBootService = greetingBootService;
    }

    public String getLocalizedGreeting() {
        return greetingBootService.sayGreeting();
    }
}
