package com.bastex.codelearninghub.spring5.context.annotations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@ComponentScan(basePackages = {"com.bastex.codelearninghub.spring5.context.annotations"},
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {Spring5CoreAnnotationConfiguration.class})})
public class Spring5CoreAnnotationConfiguration {
}
