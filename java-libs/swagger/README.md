# Swagger Documentation

Examples in this module are based on JAX-RS Jersey for Swagger integration.

Swagger is an API documentation tool that simplifies the generation of interactive API documentation for Java
applications. It enables developers to describe and document RESTful APIs in a standardized way. Below are key aspects
of integrating Swagger into your project.

## Swagger: API Documentation Tool

Swagger provides a comprehensive solution for API documentation with the following features:

### Swagger Annotations

- Swagger allows developers to use annotations like `@Api`, `@ApiOperation`, and `@ApiModel` to enrich the code with
  information about API operations and models.

### Swagger UI

- Swagger generates a user-friendly UI that visualizes and interacts with the API documentation. It allows developers
  and consumers to explore and test the API endpoints easily.

### OpenAPI Specification

- Swagger uses the OpenAPI Specification, a standard format for describing RESTful APIs. This specification is both
  human and machine-readable, making it easy to understand and share API details.

## Integration Steps

To integrate Swagger into your project, follow these general steps:

1. **Add Swagger Dependencies:**
    - Include the necessary Swagger dependencies in your project, such as `springfox-swagger2` for Spring Boot
      applications.

2. **Configure Swagger:**
    - Configure Swagger settings in your application, specifying API base packages, version information, and other
      relevant details.

3. **Use Swagger Annotations:**
    - Annotate your controllers and models with Swagger annotations to provide additional information for documentation
      generation.

4. **Access Swagger UI:**
    - Once the application is running, access the Swagger UI by navigating to the appropriate URL (
      e.g., `http://localhost:8080/swagger-ui.html`).

5. **Explore and Test APIs:**
    - Utilize the Swagger UI to explore and test your API endpoints interactively. Swagger also provides options to
      execute requests directly from the documentation.

## Example Configuration

### Spring Example Configuration

```java

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Your API Title")
                .description("Your API Description")
                .version("1.0.0")
                .build();
    }
}
```

For Spring, you typically need the following dependencies:

```xml

<dependencies>
    <dependency>
        <groupId>io.springfox</groupId>
        <artifactId>springfox-swagger2</artifactId>
        <version>${swagger.version}</version>
    </dependency>

    <dependency>
        <groupId>io.springfox</groupId>
        <artifactId>springfox-swagger-ui</artifactId>
        <version>${swagger.version}</version>
    </dependency>

    <dependency>
        <groupId>io.springfox</groupId>
        <artifactId>springfox-swagger2-annotations</artifactId>
        <version>${swagger.version}</version>
    </dependency>
</dependencies>
```

### JAX-RS Jersey Example Configuration

```java
import io.swagger.jaxrs.config.BeanConfig;

public class SwaggerConfig {

    public SwaggerConfig() {
        configureSwagger();
    }

    private void configureSwagger() {
        // Set the package where your JAX-RS resources are located
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.0");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080"); // Adjust the host and port accordingly
        beanConfig.setBasePath("/your-api-context"); // Adjust the context path accordingly
        beanConfig.setResourcePackage("com.example.resources"); // Adjust the package accordingly
        beanConfig.setTitle("Your API Title");
        beanConfig.setDescription("Your API Description");
        beanConfig.setScan(true);
    }
}
```

For JAX-RS Jersey, you might need the following dependencies:

```xml

<dependencies>
    <dependency>
        <groupId>io.swagger.core.v3</groupId>
        <artifactId>swagger-jaxrs2</artifactId>
        <version>${swagger.version}</version>
    </dependency>

    <dependency>
        <groupId>io.swagger.core.v3</groupId>
        <artifactId>swagger-core</artifactId>
        <version>${swagger.version}</version>
    </dependency>
    <dependency>
        <groupId>io.swagger.core.v3</groupId>
        <artifactId>swagger-annotations</artifactId>
        <version>${swagger.version}</version>
    </dependency>
</dependencies>
```