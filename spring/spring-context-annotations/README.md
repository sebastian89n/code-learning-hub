# spring-context-annotations

Example of using annotation based configuration in Spring Context.

In order to do that we use @ComponentScan annotation on @Configuration class
and we provide packages to scan or filters for inclusions/exclusions.

Spring Context finds beans in provided packages on classes with annotations like @Component, @Service etc.