# Spring Context

Spring Context is a crucial component of the Spring Framework, responsible for managing the lifecycle of Spring beans
and providing various services to Spring-based applications. It creates and maintains the application's object graph,
handles configuration, and allows for the injection of dependencies. Spring Context is the central hub for managing
Spring beans and their interactions.

## Modules

- **spring-context-configuration** - Demonstrates three methods of creating Spring beans: using annotations with
  @ComponentScan, using @Configuration class with @Bean annotation, and defining beans in an XML file.

- **spring-context-properties** - loading values from properties files, overriding with profiles etc.

- **spring-context-lifecycle** - some basic annotations and interfaces that can be used for handling bean lifecycle
  management

- **spring-context-dependency-injection** - examples of DI in Spring

## Overview

Spring Context plays a vital role in a Spring-based application, providing a range of features and services:

### Key Features

- **Bean Management:** Spring Context creates, configures, and manages Spring beans, ensuring they are available for use
  throughout the application.

- **Dependency Injection:** It allows for the injection of dependencies into beans, reducing tight coupling and
  promoting modularity.

- **Bean Scopes:** Spring Context supports different bean scopes (e.g., singleton, prototype, request, session) to
  control the lifecycle and behavior of beans.

- **Lifecycle Callbacks:** Beans can implement lifecycle callback interfaces (
  e.g., `InitializingBean`, `DisposableBean`) or use annotations (e.g., `@PostConstruct`, `@PreDestroy`) to perform
  actions upon bean initialization and destruction.

- **Property Value Injection:** Spring Context can inject property values from configuration files or environment
  properties into beans.

- **Component Scanning:** Spring supports component scanning to automatically detect and register beans in the context,
  reducing the need for manual bean definitions.

### Common Annotations

- **`@Component`:** The `@Component` annotation marks a class as a Spring component, allowing it to be automatically
  detected and registered in the context.

- **`@Service`:** The `@Service` annotation is a specialization of `@Component` used to identify service classes.

- **`@Repository`:** The `@Repository` annotation is a specialization of `@Component` used to indicate repository
  classes for database access.

- **`@Controller`:** The `@Controller` annotation is a specialization of `@Component` used to identify controller
  classes in a web application.

- **`@Configuration`:** The `@Configuration` annotation marks a class as a source of bean definitions, often used
  with `@Bean` methods to define beans.

- **`@Autowired`:** The `@Autowired` annotation is used for dependency injection, injecting beans or values into other
  beans.

- **`@Value`:** The `@Value` annotation is used for injecting property values from configuration files or environment
  properties.

Spring Context is at the core of Spring-based applications, providing essential services for managing beans, dependency
injection, and configuration. It promotes a modular and maintainable codebase and is instrumental in achieving the
principles of Inversion of Control (IoC) and Dependency Injection.
