package com.bastex.codelearninghub.spring5core.annotations.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
class AnnotationInitializedBeanServiceImpl implements AnnotationInitializedBeanService {
    @Override
    public void printComponentName() {
        log.info("Component name: {}", this.getClass().getSimpleName());
    }
}
