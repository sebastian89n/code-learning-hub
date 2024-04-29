package com.bastex.codelearninghub.spring.context.properties.configuration;

import com.bastex.codelearninghub.spring.context.properties.datasource.FakeDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:datasource.properties")
public class DataSourceConfiguration {
    /**
     * Values are read from datasource.properties
     */
    @Bean
    FakeDataSource fakeDataSource(@Value("${db.username}") final String username, //
                                  @Value("${db.password}") final String password,  //
                                  @Value("${db.jdbcurl}") final String jdbcUrl) {
        final FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(username);
        fakeDataSource.setPassword(password);
        fakeDataSource.setJdbcUrl(jdbcUrl);
        return fakeDataSource;
    }
}
