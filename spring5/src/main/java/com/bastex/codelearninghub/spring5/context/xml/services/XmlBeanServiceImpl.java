package com.bastex.codelearninghub.spring5.context.xml.services;

import com.bastex.codelearninghub.spring5.context.xml.beans.SampleXmlBean;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class XmlBeanServiceImpl implements XmlBeanService {
    private final SampleXmlBean sampleXmlBean;

    // only used to demonstrate initialization of properties in Spring xml context
    private final String version;

    // only used to demonstrate initialization of properties in Spring xml context
    @Setter
    private int executionCount;

    @Override
    public void printComponentType() {
        log.info("Component type: {}. Version: {}, Printing executed {} times. {}", this.getClass().getSimpleName(), version, ++executionCount, sampleXmlBean.getMessage());
    }
}
