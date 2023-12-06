package com.bastex.codelearninghub.spring.context.profiles.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service("i18nEsService")
@Profile("es")
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
