package com.bastex.codelearninghub.spring.context.xml.beans;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Bean initialized in xml context(application-context.xml)
 */
@Slf4j
@RequiredArgsConstructor
@Getter
public class MessageContainerBean {
    private final String message;
}
