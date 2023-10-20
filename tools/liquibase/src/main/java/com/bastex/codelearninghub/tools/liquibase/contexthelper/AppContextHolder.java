package com.bastex.codelearninghub.tools.liquibase.contexthelper;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationContext;

@Getter
public enum AppContextHolder {
    INSTANCE;

    @Setter
    private ApplicationContext context;
}
