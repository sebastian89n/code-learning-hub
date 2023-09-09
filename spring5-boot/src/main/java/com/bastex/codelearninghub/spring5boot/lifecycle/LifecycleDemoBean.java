package com.bastex.codelearninghub.spring5boot.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * Details in SpringBeanLifecycle05.pdf
 */
@Component
@Slf4j
public class LifecycleDemoBean implements InitializingBean, DisposableBean, BeanNameAware {
    @PostConstruct
    public void init() {
        System.out.println("\n### postConstruct is called");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("\n### afterPropertiesSet is called");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("\n### preDestroy is called");
    }

    @Override
    public void destroy() {
        System.out.println("\n### destroy method is called");
    }

    @Override
    public void setBeanName(final String name) {
        System.out.printf("\n### setBeanName is called. Bean name %s", name);
    }
}
