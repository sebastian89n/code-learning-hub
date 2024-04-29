# Spring Context Dependency Injection

Dependency injection is a design pattern where components receive their dependencies rather than creating or managing
them. In the context of Spring, dependency injection involves providing the required dependencies (usually other beans)
to a component, enabling loose coupling and promoting modular design.

## Injection Methods

### 1. Constructor Injection

Constructor injection involves providing dependencies through a class constructor. It ensures that all required
dependencies are available when an object is created.

### 2. Setter Injection

Setter injection involves providing dependencies through setter methods in the class. It allows for more flexibility as
dependencies can be changed or updated after the object is created.

### 3. Field Injection

Field injection involves injecting dependencies directly into class fields. While convenient, it's generally considered
good practice to use constructor or setter injection instead to make dependencies explicit.

## Key Annotations

### 1. `@Autowired`

The `@Autowired` annotation is used to automatically inject dependencies into a Spring bean. It can be applied to
constructors, setter methods, or directly to fields.

### 2. `@Qualifier`

The `@Qualifier` annotation is used in conjunction with `@Autowired` to specify the name of the bean to be injected when
multiple beans of the same type exist.

### 3. `@Primary`

The `@Primary` annotation is used to indicate the primary bean to be injected when multiple beans of the same type are
present. It is often used in combination with `@Autowired` and is applied to the bean definition.
