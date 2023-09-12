package com.bastex.codelearninghub.spring5.context.xml.services;

import com.bastex.codelearninghub.spring5.context.services.I18nService;

import java.util.List;

public interface XmlTranslationService {
    void printComponentType();

    List<String> getTextToTranslate();

    List<I18nService> getTranslationServices();
}
