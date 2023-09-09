package com.bastex.codelearninghub.spring5core.components;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class SampleXmlComponent {
    @Getter
    private final String message;
}
