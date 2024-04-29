package com.bastex.codelearninghub.tools.liquibase.contexthelper;

import liquibase.change.custom.CustomTaskChange;

public interface LiquibaseInitializedSpringAwareMigration extends CustomTaskChange {
    @Override
    default void setUp() {
        AppContextHolder.INSTANCE.registerAsSpringBean(this);
    }
}
