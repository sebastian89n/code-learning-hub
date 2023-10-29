package com.bastex.codelearninghub.tools.liquibase.beans;

public record LiquibaseConfig(String url,
                              String dbSchema,
                              String username,
                              String password,
                              String dbChangeLogLocation,
                              String contextsToRun) {
}
