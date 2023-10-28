# Modules

Project contains examples of Spring 5 library components

- **spring-aop** - example of Spring Aspect Oriented Programming module
- **spring-cloud-gateway** - example of Spring Cloud Gateway module with yaml mapping
- **spring-context** - Spring Context related modules
- **spring-data-jpa** - examples of JPA mapping, Spring Data repositories etc.
- **spring-mvc** examples of Spring MVC. Uses spring-data-jpa module for DAO.

## Spring Framework

The Spring Framework is a comprehensive and widely used framework for building Java-based enterprise applications. It
provides a vast array of features and modules that simplify the development of complex, scalable, and maintainable
applications. Spring promotes good programming practices, such as modularity, testability, and reusability, and it is
known for its ability to simplify common enterprise tasks. Below, you'll find an overview of the Spring framework and
some of the most common Spring modules.

## Overview

Spring's core principle is "Inversion of Control" (IoC), which means that the framework controls the flow of a program,
rather than the program controlling the framework. This concept leads to the creation of loosely coupled, easily
testable components.

### Key Features

- **IoC Container:** The Spring IoC container manages the creation and configuration of application objects. It enhances
  the modularity and testability of applications.

- **AOP (Aspect-Oriented Programming):** Spring provides support for AOP, enabling the implementation of cross-cutting
  concerns like security, logging, and transactions.

- **Dependency Injection:** Spring simplifies the injection of dependencies into objects, reducing the coupling between
  components.

- **Data Access/Integration:** Spring supports various data sources and integration technologies, making it easy to work
  with databases, messaging systems, and more.

- **Transaction Management:** Spring provides a robust framework for managing transactions, whether using programmatic
  or declarative approaches.

- **Security:** Spring Security offers a comprehensive security solution for applications, including authentication,
  authorization, and various security features.

- **Testing:** Spring's testing support allows for the creation of unit tests and integration tests with a focus on
  simplicity and maintainability.

### Common Spring Modules

Spring is highly modular, and developers can choose the modules that best suit their application's needs. Some of the
most common Spring modules include:

- **Spring Core Container:** This is the core module of the Spring framework, providing the IoC container and the
  foundational Spring beans.

- **Spring AOP:** The AOP module offers support for aspect-oriented programming in Spring applications, enabling the
  development of cross-cutting concerns.

- **Spring Data Access/Integration:** This module includes JDBC, ORM (Object-Relational Mapping), and transaction
  management features for data access and integration with various data sources.

- **Spring Data JPA:** A specialized module that simplifies data access using the Java Persistence API (JPA), providing
  powerful repository interfaces and query methods for database operations.

- **Spring MVC:** Spring offers a web module that simplifies the development of web applications, providing features
  like controllers, view resolvers, and validation.

- **Spring Web:** This module focuses on web application development and includes Spring MVC, web socket, and
  web-related features.

- **Spring Security:** Spring Security is dedicated to providing authentication and authorization capabilities for web
  applications and services.

- **Spring Testing:** The testing module simplifies the creation of unit and integration tests, allowing developers to
  ensure the robustness of their Spring-based applications.

Spring offers various other modules and projects, such as Spring Boot and Spring Cloud, tailored for
specific use cases and integration with other technologies.
