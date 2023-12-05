package com.bastex.codelearninghub.spring.context.profiles.services;

import java.util.Locale;

public class I18nEnServiceImpl implements I18nService {
    @Override
    public String getGreeting() {
        return "Hello";
    }

    @Override
    public Locale getLocale() {
        return Locale.ENGLISH;
    }
}
