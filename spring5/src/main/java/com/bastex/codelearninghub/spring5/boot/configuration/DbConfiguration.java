package com.bastex.codelearninghub.spring5.boot.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


/**
 * Automatically fills all properties starting with db prefix
 */
@ConfigurationProperties("db") // properties binding
@PropertySource("classpath:datasource.properties")
@Configuration
@Data
public class DbConfiguration {
    private String username;

    private String password;

    private String jdbcUrl;
}
