package com.bastex.codelearninghub.spring5.boot.configuration;

import com.bastex.codelearninghub.spring5.boot.beans.UserPersistenceService;
import com.bastex.codelearninghub.spring5.boot.datasource.FakeDataSource;
import com.bastex.codelearninghub.spring5.boot.services.GoogleService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:datasource.properties")
public class AppConfiguration {
    /**
     * By the default method name becomes Spring Bean in the context unless specified directly in the annotation as in the example below
     */
    @Bean(name = "beanInitializedInConfiguration")
    UserPersistenceService userPersistenceService() {
        return new UserPersistenceService();
    }

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

    @Bean
    GoogleService googleService(@Value("${googlecs.url}") final String googleCsUrl) {
        final GoogleService googleService = new GoogleService(googleCsUrl);
        return googleService;
    }
}
