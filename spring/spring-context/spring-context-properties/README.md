# Spring Context Properties

## Overview

Spring properties offer a powerful mechanism for configuring your application externally, allowing you to
customize its behavior without modifying the source code. This module serves as a guide to understanding Spring
properties, utilizing profiles, and demonstrating flexibility in configuration.

## What are Spring Properties?

In a Spring application, properties are configuration settings that define the behavior of the application. These
settings can include database connection details, server configurations, logging levels, and more. Spring Boot provides
a convenient way to manage these properties, allowing you to externalize configuration and make your application
adaptable to different environments.

## Using Spring Properties

### 1. Configuration Basics

Properties in Spring are key-value pairs that can be defined in various ways. Here's a basic example of a property:

```properties
# application.properties
app.version=1.0.0
```

In this example, `app.version` is a property with the value `1.0.0`. You can access this property in your Java code
using
the `@Value` annotation or through the Environment object.

### 2. Profiles

Spring supports profiles, allowing you to have different configurations for different environments (e.g., development,
production). To use profiles, create separate configuration files for each profile. For instance:

- `application-dev.properties` for development
- `application-prod.properties` for production

Activate a profile by setting the spring.profiles.active property. For example:

```properties
# application.properties
spring.profiles.active=dev

```

Now, the application will use properties from `application-dev.properties`.

The properties in the profile-specific files, such as `application-dev.properties`, are applied on top of the
basic `application.properties`. This means that properties defined in the profile-specific file will override any
conflicting properties defined in the basic file.

This property inheritance and override mechanism provide a convenient way to customize configurations for different
environments without duplicating the entire configuration. Only the necessary properties for a specific profile need to
be defined in the corresponding profile-specific file.

### 3. YAML Configuration

In addition to properties files, Spring also supports YAML for configuration. YAML is often more readable and allows for
nested structures. Example:

```yaml
# application.yml

server:
  port: 8080

app:
  name: MySpringApp
```

### 4. Annotation-Based Configuration

Spring provides several annotations for handling properties in a more structured way:

`@Value`
Use this annotation to directly inject values from properties into your Spring beans. For example:

```java
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyComponent {

    @Value("${app.version}")
    private String appVersion;

    // ... rest of the code
}
```

`@PropertySource`
Use this annotation to specify the properties file to be used. For example:

```java
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:custom.properties")
public class CustomComponent {

    // ... rest of the code
}

```

`@ConfigurationProperties`
Use this annotation to bind properties to a Java class. For example:

```java
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app")
public class AppConfig {

    private String name;

    // getters and setters

    // ... rest of the code
}
```

`@ConstructorBinding`
This annotation is used in conjunction with @ConfigurationProperties to indicate that the configuration properties
should be bound to the constructor parameters. This is especially useful when you want to create immutable configuration
classes. For example:

```java
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app")
@ConstructorBinding
public class ImmutableAppConfig {

    private final String name;

    public ImmutableAppConfig(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // ... rest of the code
}
```