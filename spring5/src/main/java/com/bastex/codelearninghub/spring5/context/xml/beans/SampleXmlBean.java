package com.bastex.codelearninghub.spring5.context.xml.beans;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Bean initialized in xml context(application-context.xml)
 */
@Slf4j
@RequiredArgsConstructor
public class SampleXmlBean {
    @Getter
    private final String message;
}
