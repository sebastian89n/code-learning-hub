package com.bastex.codelearninghub.tools.liquibase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * EnableJpaRepositories and EntityScan are required here because we load repositories and entities from a different package.
 * By the default it wouldn't be required if entities were within same module in subpackages.
 * <p>
 * We set ApplicationContext to Singleton instance because Liquibase scripts that initialize CustomTaskChange do not use Spring context.
 */
@SpringBootApplication(scanBasePackages = {"com.bastex.codelearninghub.spring.data.services"})
@EnableJpaRepositories(basePackages = "com.bastex.codelearninghub.spring.data.repositories")
@EntityScan("com.bastex.codelearninghub.spring.data.domain")
public class LiquibaseApp {
    public static void main(final String[] args) {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(LiquibaseApp.class, args);
        AppContext.INSTANCE.setContext(applicationContext);
    }
}
