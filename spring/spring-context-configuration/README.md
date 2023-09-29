# spring-context-configuration

Example of using configuration based configuration in Spring Context.

We create @Configuration classes that defines Spring beans in its methods using @Bean annotation.

By default method name becomes the name of the bean unless specified directly in the annotation.

There's one main @Configuration class, but you can include others using @Import annotation.

In this example Spring context is initialized with AnnotationConfigApplicationContext.