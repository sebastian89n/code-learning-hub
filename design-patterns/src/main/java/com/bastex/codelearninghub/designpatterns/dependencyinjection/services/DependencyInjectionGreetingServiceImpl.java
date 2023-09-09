package com.bastex.codelearninghub.designpatterns.dependencyinjection.services;

public class DependencyInjectionGreetingServiceImpl implements DependencyInjectionGreetingService {
    @Override
    public String sayGreeting() {
        return "Hello world!";
    }
}
