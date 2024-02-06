package com.bastex.codelearninghub.spring.context.lifecycle.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;


/**
 * Usually one of the two ways is used - implement InitializingBean and/or DisposableBean
 * Or use annotations like @PostConstruct and @PreDestroy.
 * <p>
 * BeanNameAware - one of the Spring Aware interfaces.
 * It indicates that the bean is eligible to be notified by the Spring container through the callback methods
 */
@Component
@Slf4j
public class LifecycleDemoBean implements InitializingBean, DisposableBean, BeanNameAware {
    @PostConstruct
    public void init() {
        log.info("\n### postConstruct is called");
    }

    @PreDestroy
    public void preDestroy() {
        log.info("\n### preDestroy is called");
    }

    @Override
    public void afterPropertiesSet() {
        log.info("\n### afterPropertiesSet is called");
    }

    @Override
    public void destroy() {
        log.info("\n### destroy method is called");
    }

    @Override
    public void setBeanName(final String name) {
        log.info("\n### setBeanName is called. Bean name {}", name);
    }
}
