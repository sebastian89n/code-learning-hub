package com.bastex.codelearninghub.spring.context.configuration.services;

import java.util.Locale;

public interface I18nService {
    String getGreeting();

    Locale getLocale();
}
