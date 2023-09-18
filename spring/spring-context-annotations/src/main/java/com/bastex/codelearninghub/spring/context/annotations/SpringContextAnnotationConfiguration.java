package com.bastex.codelearninghub.spring.context.annotations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@ComponentScan(basePackages = {"com.bastex.codelearninghub.spring.context.annotations"},
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {SpringContextAnnotationConfiguration.class})})
public class SpringContextAnnotationConfiguration {
}
