package com.bastex.codelearninghub.spring.context.configuration.services;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public class TranslationService {
    private final Map<Locale, I18nService> translationServicePerLocale;

    public TranslationService(@NonNull final List<I18nService> translationServices) {
        this.translationServicePerLocale = translationServices.stream()
                .collect(Collectors.toMap(I18nService::getLocale, Function.identity()));
    }

    public String prepareUserGreetingInLocale(final String userName, final Locale targetLocale) {
        final I18nService i18nService = translationServicePerLocale.get(targetLocale);
        if (i18nService == null) {
            throw new IllegalArgumentException("Unsupported locale");
        }

        return i18nService.getGreeting() + " " + userName;
    }
}
