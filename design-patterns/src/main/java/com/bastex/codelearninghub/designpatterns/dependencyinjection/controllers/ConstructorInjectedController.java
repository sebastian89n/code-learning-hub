package com.bastex.codelearninghub.designpatterns.dependencyinjection.controllers;

import com.bastex.codelearninghub.designpatterns.dependencyinjection.services.DependencyInjectionGreetingService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConstructorInjectedController {
    private final DependencyInjectionGreetingService dependencyInjectionGreetingService;

    public String getGreeting() {
        return dependencyInjectionGreetingService.sayGreeting();
    }
}
