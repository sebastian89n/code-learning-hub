package com.bastex.codelearninghub.spring.context.configuration.services;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DogServiceImpl implements PetService {
    private final I18nService i18nService;

    @Override
    public String callAnimal() {
        return i18nService.getGreeting() + " dog";
    }
}
