package com.bastex.codelearninghub.designpatterns.dependencyinjection.controllers;

import com.bastex.codelearninghub.designpatterns.dependencyinjection.services.DependencyInjectionGreetingService;
import lombok.Setter;

public class SetterInjectedController {
    @Setter
    private DependencyInjectionGreetingService dependencyInjectionGreetingService;

    public String getGreeting() {
        return dependencyInjectionGreetingService.sayGreeting();
    }
}
