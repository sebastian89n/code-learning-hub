package com.bastex.codelearninghub.tools.liquibase;

import com.bastex.codelearninghub.tools.liquibase.beans.LiquibaseConfig;
import com.bastex.codelearninghub.tools.liquibase.contexthelper.AppContextHolder;
import com.bastex.codelearninghub.tools.liquibase.migrations.DbMigrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * EnableJpaRepositories and EntityScan are required here because we load repositories and entities from a different module with diff package.
 * It wouldn't be required if entities were within same package/subpackages of this class.
 * <p>
 * We set ApplicationContext to Singleton instance because Liquibase code that initializes CustomTaskChange do not use Spring context by default.
 * <p>
 * Configured via application.properties
 */
@Slf4j
@EntityScan("com.bastex.codelearninghub.spring.data.domain")
@EnableJpaRepositories(basePackages = "com.bastex.codelearninghub.spring.data.repositories")
@SpringBootApplication(scanBasePackages = {
        "com.bastex.codelearninghub.tools.liquibase",
        "com.bastex.codelearninghub.spring.data.services"
})
public class LiquibaseApp {
    public static void main(final String[] args) {
        try (final ConfigurableApplicationContext applicationContext = SpringApplication.run(LiquibaseApp.class)) {
            AppContextHolder.INSTANCE.setContext(applicationContext);
            final DbMigrationService dbMigrationService = applicationContext.getBean(DbMigrationService.class);
            dbMigrationService.runMigration();
        } catch (final RuntimeException e) {
            log.error("Unable to execute the migration", e);
        }
    }

    /**
     * Value(${paramName:defaultValue})
     */
    @Bean
    LiquibaseConfig liquibaseConfig(@Value("${spring.datasource.url}") final String url,
                                    @Value("${spring.liquibase.default-schema:}") final String dbSchema,
                                    @Value("${spring.datasource.username}") final String username,
                                    @Value("${spring.datasource.password:}") final String password,
                                    @Value("${spring.liquibase.change-log}") final String dbChangelogLocation,
                                    @Value("${spring.liquibase.contexts:update}") final String contextsAsText) {
        return new LiquibaseConfig(url, dbSchema, username, password, dbChangelogLocation, contextsAsText);
    }
}
