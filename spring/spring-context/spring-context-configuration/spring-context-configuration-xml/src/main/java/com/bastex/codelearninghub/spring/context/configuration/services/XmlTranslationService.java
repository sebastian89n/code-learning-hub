package com.bastex.codelearninghub.spring.context.configuration.services;

import java.util.List;
import java.util.Set;

public interface XmlTranslationService {
    void printComponentType();

    Set<String> getSupportedLanguages();

    List<I18nService> getTranslationServices();
}
