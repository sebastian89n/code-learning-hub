package com.bastex.codelearninghub.spring.context.properties;

import com.bastex.codelearninghub.spring.context.properties.configuration.PropertySourceConstructorDbConfiguration;
import com.bastex.codelearninghub.spring.context.properties.configuration.PropertySourcesDbConfiguration;
import com.bastex.codelearninghub.spring.context.properties.datasource.FakeDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties(PropertySourceConstructorDbConfiguration.class)
@Slf4j
public class SpringPropertiesApp {
    public static void main(final String[] args) {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringPropertiesApp.class, args);

        final FakeDataSource fakeDataSource = applicationContext.getBean(FakeDataSource.class);
        log.info("{}", fakeDataSource);

        final PropertySourcesDbConfiguration dbConfiguration = applicationContext.getBean(PropertySourcesDbConfiguration.class);
        log.info("{}", dbConfiguration);

        final PropertySourceConstructorDbConfiguration propertySourceConstructorDbConfiguration = applicationContext.getBean(PropertySourceConstructorDbConfiguration.class);
        log.info("{}", propertySourceConstructorDbConfiguration);
    }
}
