package com.bastex.codelearninghub.spring.context.profiles.services;

import java.util.Locale;

public class I18nEsServiceImpl implements I18nService {
    private static final Locale SPANISH_LOCALE = new Locale("es");

    @Override
    public String getGreeting() {
        return "Hola";
    }

    @Override
    public Locale getLocale() {
        return SPANISH_LOCALE;
    }
}
