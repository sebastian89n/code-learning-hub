# Spring Bean Scopes Overview

## Introduction

In the Spring Framework, a bean is a managed component that is created and managed by the Spring IoC (Inversion of
Control) container. Bean scope defines the lifecycle and visibility of a bean within the container. Spring supports
various built-in bean scopes and also allows you to create custom scopes to cater to specific use cases.

## Standard Scopes

### 1. Singleton Scope

- **Description:** The default scope. Only one instance of the bean is created per Spring IoC container.
- **Configuration:** `@Scope("singleton")` or simply `@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)` annotation.

### 2. Prototype Scope

- **Description:** A new instance is created every time the bean is requested.
- **Configuration:** `@Scope("prototype")` or `@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)` annotation.

## Web Scopes

### 1. Request Scope

- **Description:** A new instance for each HTTP request. Applicable in a web-aware Spring context.
- **Configuration:** `@Scope(value = WebApplicationContext.SCOPE_REQUEST)` or `@RequestScope` annotation.

### 2. Session Scope

- **Description:** A new instance for each HTTP session. Applicable in a web-aware Spring context.
- **Configuration:** `@Scope(value = WebApplicationContext.SCOPE_SESSION)` or `@SessionScope` annotation.

### 3. Global Session Scope

- **Description:** A new instance for each global HTTP session. Applicable in a web-aware Spring context.
- **Configuration:** `@Scope(value = WebApplicationContext.SCOPE_GLOBAL_SESSION)` annotation.

## Custom Scopes

### 1. Creating Custom Scopes

You can create custom bean scopes to meet specific requirements. One example is the custom thread scope, where a new
instance is created for each thread.

### 2. Example: Custom Thread Scope

To create a custom thread scope, follow these steps:

- Implement the custom scope class, e.g., `CustomThreadScope`.
- Register the custom scope with the Spring context.
- Annotate the bean with the custom scope.

## Choosing the Right Scope

- **Singleton:** Use when a single shared instance is required.
- **Prototype:** Use when a new instance is needed every time.
- **Request/Session/GlobalSession:** Use in web applications where beans need to be tied to specific HTTP scopes.
- **Custom Scopes:** Create custom scopes to meet specific requirements, such as thread-specific instances.
