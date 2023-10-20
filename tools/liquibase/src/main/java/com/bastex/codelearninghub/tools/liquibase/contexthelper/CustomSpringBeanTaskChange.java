package com.bastex.codelearninghub.tools.liquibase.contexthelper;

import liquibase.change.custom.CustomTaskChange;

public interface CustomSpringBeanTaskChange extends CustomTaskChange {
    @Override
    default void setUp() {
        AppContextHolder.INSTANCE.getContext()
                .getAutowireCapableBeanFactory()
                .autowireBean(this);
    }
}
