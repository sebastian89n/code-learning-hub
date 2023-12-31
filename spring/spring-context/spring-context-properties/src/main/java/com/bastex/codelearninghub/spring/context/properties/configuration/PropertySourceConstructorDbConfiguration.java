package com.bastex.codelearninghub.spring.context.properties.configuration;

import lombok.Getter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.context.annotation.PropertySource;

/**
 * Constructor binding examples
 */
@ConfigurationProperties(prefix = "db") // properties binding
// Used to bind properties to constructor param for immutable objects. Deprecated and optional in Spring Boot 3.x, required in Spring Boot 2.x
@ConstructorBinding
@PropertySource("classpath:datasource.properties")
@Getter
@ToString
public class PropertySourceConstructorDbConfiguration {
    private final String username;

    private final String password;

    private final String jdbcUrl;

    public PropertySourceConstructorDbConfiguration(final String username, final String password, final String jdbcUrl) {
        this.username = username;
        this.password = password;
        this.jdbcUrl = jdbcUrl;
    }
}
