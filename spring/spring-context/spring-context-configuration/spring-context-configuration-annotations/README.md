# Spring Context Configuration With Annotations

In this example, we demonstrate how to configure the Spring context using annotations. To achieve this, we utilize
the `@ComponentScan` annotation within an `@Configuration` class. This annotation allows us to specify packages to scan
or provide filters for inclusions/exclusions.

When using annotation-based configuration, the Spring Context discovers beans in the specified packages based on class
annotations such as `@Component`, `@Service`, and others.

To initialize the Spring context in this example, we use `AnnotationConfigApplicationContext`. This context
initialization method enables the discovery and registration of beans declared through annotation scanning.

By employing annotation-based configuration, we leverage the power of annotations to succinctly define and manage beans
in our Spring application.
