package com.bastex.codelearninghub.spring5.boot.lifecycle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * BeanPostProcessor - very rare cases when it needs to be used. It is used to intercept initialization process of every bean.
 * It is called for every bean initialized by the Spring context
 */
@Slf4j
//@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(final Object bean, final String beanName) throws BeansException {
        log.info("### postProcessBeforeInitialization is called for bean {}", beanName);

        if (bean instanceof LifecycleDemoBean && beanName.equals("lifecycleDemoBEan")) {
//            LifecycleDemoBean lifecycleDemoBean = (LifecycleDemoBean) bean;
//            lifecycleDemoBean.setBeanName("asd");
            // doSomething
        }
        // if overridden will be called when every Spring bean is initialized
        // calling default interface method:
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(final Object bean, final String beanName) throws BeansException {
        log.info("### postProcessAfterInitialization is called for bean {}", beanName);

        if (bean instanceof LifecycleDemoBean) {
            // doSomething
        }
        // if overridden will be called when every Spring bean is initialized
        // calling default interface method:
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
