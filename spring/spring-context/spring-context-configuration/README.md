# Spring Configuration - Bean Creation

This repository provides examples of different ways to create beans in a Spring application. Beans are the fundamental
building blocks in a Spring application and are managed by the Spring IoC (Inversion of Control) container.

## Modules

- **spring-context-annotations** - Demonstrates configuring the Spring context using an @Configuration class combined
  with @ComponentScan. This method leverages annotations such as @Component, @Service, or @Repository for bean
  registration.
- **spring-context-configuration** - Illustrates configuring the Spring context using an @Configuration class with
  individual @Bean annotations. This approach involves explicitly declaring and instantiating beans within the
  configuration class.
- **spring-context-xml** - Provides an example of configuring the Spring context using XML. This method involves
  defining beans and their relationships in an XML configuration file, offering

## 1. Using Annotations and @ComponentScan

In this approach, you can create beans by using annotations such as `@Component`, `@Service`, `@Repository`, etc., and
then utilize `@ComponentScan` to automatically detect and register them.

### Example:

```java
import org.springframework.stereotype.Component;

@Component
public class MyBean {
    // Bean implementation
}
```

In the main @Configuration class:

```java

@Configuration
@ComponentScan(basePackages = {"com.bastex.codelearninghub.spring.context.annotations.beans"})
public class SpringContextAnnotationConfiguration {
}
```

## 2. Using @Configuration Class and @Bean Annotation

In this approach, you can create a configuration class annotated with `@Configuration` and define methods annotated with
`@Bean` to declare and instantiate beans.

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MyBean myBean() {
        return new MyBean();
    }
}
```

```java
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApplication {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(AppConfig.class)) {
            MyBean myBean = context.getBean(MyBean.class);
            // Use myBean
        }
    }
}
```

## 3. Using XML Configuration

Alternatively, you can define beans in an XML configuration file.

```xml
<!-- applicationContext.xml -->
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="myBean" class="com.bastex.codelearninghub.spring.context.configuration"/>
</beans>
```

```java
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApplication {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context =
                     new ClassPathXmlApplicationContext("applicationContext.xml")) {
            MyBean myBean = context.getBean(MyBean.class);
            // Use myBean
        }
    }
}
```

## 4. Mixing Bean Creation Methods

While it's technically possible to mix the three methods mentioned above within a Spring application, it's generally not
recommended due to potential complexity and reduced readability. Mixing methods may lead to unintended consequences,
such as bean duplication or conflicts.

If you decide to combine these approaches, be cautious and ensure that there are no conflicts or ambiguity in bean
definitions. Spring's IoC container might behave unpredictably when encountering duplicate bean definitions.

It's recommended to choose a consistent approach for bean creation based on your project requirements and stick to that
approach for better maintainability and understanding.

Remember, simplicity and clarity are crucial in maintaining a clean and manageable codebase. Consider the specific needs
of your project and choose the most suitable method or combination of methods accordingly.

In certain situations, you might encounter projects with a legacy codebase using different bean creation methods. This
could be due to historical reasons, such as the widespread use of XML configurations in earlier Spring versions.

Additionally, during migration from XML configurations to Java configurations, you might find a need to mix the three
methods described earlier. However, it's important to note that this approach is more commonly associated with legacy
code or transitional phases and is generally not recommended for new projects.
