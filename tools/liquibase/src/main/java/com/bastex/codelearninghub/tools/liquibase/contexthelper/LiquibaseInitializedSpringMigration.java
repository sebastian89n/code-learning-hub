package com.bastex.codelearninghub.tools.liquibase.contexthelper;

import liquibase.change.custom.CustomTaskChange;

public interface LiquibaseInitializedSpringMigration extends CustomTaskChange {
    @Override
    default void setUp() {
        AppContextHolder.INSTANCE.registerAsSpringBean(this);
    }
}
