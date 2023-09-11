package com.bastex.codelearninghub.spring5.context.configuration.services;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CatServiceImpl implements PetService {
    private final I18nService i18nService;

    @Override
    public String getFavouritePet() {
        return i18nService.getGreeting() + " cat";
    }
}
