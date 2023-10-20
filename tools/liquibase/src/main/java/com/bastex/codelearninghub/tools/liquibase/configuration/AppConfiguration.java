package com.bastex.codelearninghub.tools.liquibase.configuration;

import com.bastex.codelearninghub.tools.liquibase.beans.LiquibaseConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    /**
     * Value(${param:defaultValue})
     */
    @Bean
    LiquibaseConfig liquibaseConfig(@Value("${spring.datasource.url}") final String url,
                                    @Value("${spring.liquibase.default-schema:}") final String dbSchema,
                                    @Value("${spring.datasource.username:}") final String username,
                                    @Value("${spring.datasource.password:}") final String password,
                                    @Value("${spring.liquibase.change-log}") final String dbChangelogLocation,
                                    @Value("${spring.liquibase.contexts:update}") final String contextsAsText) {
        return new LiquibaseConfig(url, dbSchema, username, password, dbChangelogLocation, contextsAsText);
    }
}
