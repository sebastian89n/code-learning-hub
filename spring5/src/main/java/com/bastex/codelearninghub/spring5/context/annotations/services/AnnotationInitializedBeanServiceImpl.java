package com.bastex.codelearninghub.spring5.context.annotations.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
class AnnotationInitializedBeanServiceImpl implements AnnotationInitializedBeanService {
    @Override
    public void printComponentType() {
        log.info("Component type: {}", this.getClass().getSimpleName());
    }
}
