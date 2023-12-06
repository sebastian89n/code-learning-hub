package com.bastex.codelearninghub.spring.context.configuration.services;

import com.bastex.codelearninghub.spring.context.configuration.beans.MessageContainerBean;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@Setter
@Getter
public class XmlTranslationServiceImpl implements XmlTranslationService {
    private final MessageContainerBean messageContainerBean;

    // only used to demonstrate initialization of properties in Spring xml context
    private final String version;

    // only used to demonstrate initialization of properties in Spring xml context
    private int translationQueryCount;

    // only used to demonstrate initialization of properties in Spring xml context
    private final Set<String> supportedLanguages;

    private List<I18nService> translationServices;

    @Override
    public void printComponentType() {
        log.info("Component type: {}. Version: {}, Printing executed {} times. {}", this.getClass().getSimpleName(), version, ++translationQueryCount, messageContainerBean.message());
    }

    public void init() {
        log.info("Init method");
    }

    public void destroy() {
        log.info("Destroy method");
    }
}
