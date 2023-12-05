package com.bastex.codelearninghub.spring.context.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = {"com.bastex.codelearninghub.spring.context.configuration.services",
        "com.bastex.codelearninghub.spring.context.configuration.beans"},
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {SpringContextAnnotationConfiguration.class})})
public class SpringContextAnnotationConfiguration {
}
