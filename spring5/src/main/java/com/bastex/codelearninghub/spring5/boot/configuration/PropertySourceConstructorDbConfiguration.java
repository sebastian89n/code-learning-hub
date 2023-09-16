package com.bastex.codelearninghub.spring5.boot.configuration;

import lombok.Getter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;
import org.springframework.context.annotation.PropertySource;

/**
 * Constructor binding examples
 */
@ConfigurationProperties("db") // properties binding
@PropertySource("classpath:datasource.properties")
@Getter
@ToString
public class PropertySourceConstructorDbConfiguration {
    private final String username;

    private final String password;

    private final String jdbcUrl;

    @ConstructorBinding
    // Used to bind properties to constructor param for immutable objects. Can be omitted in later versions of Spring
    public PropertySourceConstructorDbConfiguration(final String username, final String password, final String jdbcUrl) {
        this.username = username;
        this.password = password;
        this.jdbcUrl = jdbcUrl;
    }
}
