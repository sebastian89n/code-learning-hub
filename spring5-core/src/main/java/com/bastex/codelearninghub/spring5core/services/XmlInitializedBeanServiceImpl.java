package com.bastex.codelearninghub.spring5core.services;

import com.bastex.codelearninghub.spring5core.components.SampleXmlComponent;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class XmlInitializedBeanServiceImpl implements BeanService {
    private final SampleXmlComponent sampleXmlComponent;

    // only used to demonstrate initialization of properties in Spring xml context
    private final String version;

    // only used to demonstrate initialization of properties in Spring xml context
    @Setter
    private int executionCount;

    @Override
    public void printComponentName() {
        log.info("Component name: XmlInitializedBeanServiceImpl. Version: {}, Printing executed {} times. {}", version, ++executionCount, sampleXmlComponent.getMessage())
        ;
    }
}
