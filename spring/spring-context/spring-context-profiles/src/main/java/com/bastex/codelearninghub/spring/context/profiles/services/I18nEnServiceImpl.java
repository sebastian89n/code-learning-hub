package com.bastex.codelearninghub.spring.context.profiles.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service("i18nEnService")
@Profile({"default", "en"})
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
