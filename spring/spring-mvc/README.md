# Spring MVC: Building Web Applications with Spring

Spring MVC, part of the Spring Framework, is a widely used module for building web applications in Java. It provides a
powerful and flexible framework for developing web applications with the Model-View-Controller (MVC) architectural
pattern. Spring MVC is known for its simplicity and extensibility, making it a popular choice for creating robust and
scalable web applications.

This module contains an example of basic spring-mvc application.

It contains simple controllers, rest controllers and views to display the data.

Basic UI in Thymeleaf+Bootstrap to demonstrate view aspect.

Spring Boot uses convention over configuration approach so a lot of things are pre-cofnigured like Thymeleaf template
engine or Jackson.

It has a dependency to spring-data-jpa module to get pre-defined services, repositories and data.

Server deploys on `localhost:8080`

H2 console is available on: `http://localhost:8080/h2-console`

JDBC url `jdbc:h2:mem:app-db`

username/password as predefined

## Overview

Spring MVC offers a range of features and annotations to simplify web application development and promote best practices
in web architecture:

### Key Features

- **Model-View-Controller (MVC):** Spring MVC follows the MVC architectural pattern, which separates the application
  into three main components: the Model (data), the View (presentation), and the Controller (user input processing).

- **DispatcherServlet:** A central component in Spring MVC, the `DispatcherServlet` handles incoming HTTP requests,
  dispatching them to the appropriate controllers and views.

- **Controller Classes:** Controllers handle user requests, perform business logic, and return appropriate responses,
  such as data models or views.

- **View Resolvers:** Spring MVC supports various view resolvers, allowing developers to render views in different
  formats (e.g., JSP, Thymeleaf, or JSON).

- **Data Binding:** Spring MVC simplifies data binding between HTTP request parameters and Java objects, streamlining
  form handling and data validation.

- **Validation:** The framework provides a robust validation framework for performing data validation and returning
  validation errors to the user.

### Common Annotations

- **`@Controller`:** The `@Controller` annotation marks a class as a controller, defining it as a component responsible
  for processing user requests.

- **`@RestController`:** The `@RestController` annotation is a specialization of `@Controller` that indicates the class
  is primarily used for building RESTful APIs. It simplifies the process of returning data in response to HTTP requests
  and is equivalent of using `@Controller` and `@ResponsBody` together on the class level.

- **`@RequestMapping`:** The `@RequestMapping` annotation is used to map URL patterns to controller methods, specifying
  which method handles specific request paths.

- **`@RequestMapping`:** The `@RequestMapping` annotation is used to map URL patterns to controller methods, specifying
  which method handles specific request paths.

- **`@GetMapping`:** The `@GetMapping` annotation is a shortcut for specifying that a method should handle HTTP GET
  requests. It is equivalent to @RequestMapping(method = RequestMethod.GET)

- Other annotations like `@PostMapping`, `@PutMapping`, `@DeleteMapping`, and `@PatchMapping` are used for specific HTTP
  methods.

- **`@RequestParam`:** The `@RequestParam` annotation binds HTTP request parameters to controller method parameters,
  simplifying data retrieval from the request.

- **`@ModelAttribute`:** The `@ModelAttribute` annotation binds a method's return value to a model attribute, making it
  accessible in the view.

- **`@PathVariable`:** The `@PathVariable` annotation extracts values from the URL path and maps them to controller
  method parameters.

Spring MVC is a versatile framework for building web applications, whether you're creating traditional web pages or
building RESTful APIs. Its modular architecture allows you to use only the components that are relevant to your project,
promoting clean, maintainable, and scalable code.




