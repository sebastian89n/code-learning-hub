# # Spring Context Configuration With @Configuration classes and @Beans

In this example, we showcase the usage of configuration-based configuration in the Spring context. This involves
creating `@Configuration` classes, where each class defines Spring beans through methods annotated with `@Bean`.

By default, the method name becomes the name of the bean, unless explicitly specified in the `@Bean` annotation.

In this configuration style, you typically have a primary `@Configuration` class that houses the main bean definitions.
Additionally, you can include other configuration classes using the `@Import` annotation, allowing for modular and
organized bean configuration.

To initialize the Spring context in this example, we use `AnnotationConfigApplicationContext`. This method of context
initialization enables the registration and instantiation of beans defined in the configuration classes.

Through configuration-based configuration, we emphasize the explicit declaration of beans in Java code, providing a
structured and programmatic approach to configuring the Spring application context.
