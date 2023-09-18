package com.bastex.codelearninghub.spring.context.xml.services;

import java.util.List;

public interface XmlTranslationService {
    void printComponentType();

    List<String> getTextToTranslate();

    List<I18nService> getTranslationServices();
}
