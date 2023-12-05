# Spring Context Profiles

Spring profiles allow you to define sets of beans and configurations that are activated under specific runtime
conditions. This is particularly useful for managing configurations across different environments or scenarios.

## 1. Defining Profiles

Profiles can be defined in various ways:

### a. Annotation-Based Profiles

```java

@Configuration
@Profile("development")
public class DevelopmentConfig {
    // Development-specific configurations
}

@Configuration
@Profile("production")
public class ProductionConfig {
    // Production-specific configurations
}
```

### b. XML-Based Profiles

```xml
<!-- applicationContext.xml -->
<beans profile="development">
    <!-- Development-specific beans and configurations -->
</beans>

<beans profile="production">
<!-- Production-specific beans and configurations -->
</beans>
```

## 2. Activating Profiles

Profiles can be activated in different ways:

### a. Through Configuration

```java
public class MainApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("development");
        context.register(DevelopmentConfig.class, ProductionConfig.class);
        context.refresh();
        // Context is now initialized with the "development" profile
    }
}
```

### b. Through Command Line

```bash
java -jar your-application.jar --spring.profiles.active=production
```

### c. Through application.properties

You can specify the active profiles directly in your application.properties or application.yml file:

```properties
spring.profiles.active=staging
```

## 3. Default Profiles

You can set a default profile that is activated when no other profiles are explicitly specified.

### a. Annotation-Based Default Profile

```java

@Configuration
@Profile("default")
public class DefaultConfig {
    // Default configurations
}
```

### b. XML-Based Default Profile

```xml
<!-- applicationContext.xml -->
<beans default-profile="default">
    <!-- Default beans and configurations -->
</beans>
```

## Conclusion

Profiles in Spring provide a powerful mechanism for managing different configurations. Whether you need
environment-specific settings or conditional beans, profiles offer flexibility in tailoring your application to diverse
runtime requirements.