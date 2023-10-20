package com.bastex.codelearninghub.tools.liquibase.contexthelper;

import lombok.Setter;
import org.springframework.context.ApplicationContext;

public enum AppContextHolder {
    INSTANCE;

    @Setter
    private ApplicationContext context;

    public <T> void registerAsSpringBean(final T object) {
        context.getAutowireCapableBeanFactory()
                .autowireBean(object);
    }
}
