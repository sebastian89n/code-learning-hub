package com.bastex.codelearninghub.spring.context.xml.services;

import com.bastex.codelearninghub.spring.context.xml.beans.MessageContainerBean;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Setter
@Getter
public class XmlTranslationServiceImpl implements XmlTranslationService {
    private final MessageContainerBean messageContainerBean;

    // only used to demonstrate initialization of properties in Spring xml context
    private final String version;

    // only used to demonstrate initialization of properties in Spring xml context
    private final List<String> textToTranslate;

    // only used to demonstrate initialization of properties in Spring xml context
    private int executionCount;

    private List<I18nService> translationServices;

    @Override
    public void printComponentType() {
        log.info("Component type: {}. Version: {}, Printing executed {} times. {}", this.getClass().getSimpleName(), version, ++executionCount, messageContainerBean.message());
    }
}
