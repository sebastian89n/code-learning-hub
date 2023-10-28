# JAX-RS - Jakarta RESTful Web Services (formerly Java API for RESTful Web Services)

JAX-RS is a powerful Java-based framework designed for creating web
services following the principles of Representational State Transfer (REST). With a set of APIs and annotations, JAX-RS
simplifies the development of RESTful web services in Java.

Module contains simple JAX-RS application using Jersey implementation.
It uses Grizzly server to run the code.

Sample curls to execute against running application:

```
curl -i localhost:8080/api/feedbacks -X PUT -H 'Content-Type: application/json' -H 'Accept: application/json' --data '{"
userId":"user123","text": "Some feedback"}'
```

```
curl -i -X GET localhost:8080/api/feedbacks -H 'Accept: application/json'
```

```
curl -i -X GET localhost:8080/api/feedbacks/1 -H 'Accept: application/json'
```

```
curl -i -X DELETE localhost:8080/api/feedbacks/1 -H 'Accept: application/json'
```

## Overview

JAX-RS stands as a standard API that streamlines the process of building RESTful web services in Java. It empowers
developers to craft web services that are accessible via HTTP, adhering to REST's principles, which encompass using HTTP
methods like GET, POST, PUT, and DELETE while working with resources as representations. JAX-RS facilitates the
creation, exposure, and consumption of RESTful web services in Java applications.

## Common Annotations

JAX-RS provides a rich set of annotations to make it easier to develop RESTful web services. Below are some of the most
commonly used annotations:

1. `@Path`: Specifies the base URI for a resource class or method. It defines the URL path that maps to the resource or
   resource method.

2. `@GET`, `@POST`, `@PUT`, `@DELETE`: Indicate the HTTP methods that a resource method can handle. For instance, `@GET`
   signifies that a method should process HTTP GET requests.

3. `@Produces` and `@Consumes`: Define the media types that a resource method can produce and consume. For
   example, `@Produces("application/json")` declares that a method produces JSON data.

4. `@PathParam`, `@QueryParam`, `@FormParam`: Extract data from the URL path, query parameters, and form parameters,
   respectively.

5. `@Context`: Injects contextual information into a resource method, such as:

- `SecurityContext` – Security context instance for the current HTTP request
- `Request` – Used for setting precondition request processing
- `Application`, `Configuration`, and `Providers` -> Provide access to the JAX-RS application, configuration, and
  providers instances
- `ResourceContext` – Resource context class instances
- `ServletConfig` – The ServletConfig instance
- `ServletContext` – The ServletContext instance
- `HttpServletRequest` – The HttpServletRequest instance for the current request
- `HttpServletResponse` – The HttpServletResponse instance for the current request
- `HttpHeaders` – Maintains the HTTP header keys and values
- `UriInfo` – Query parameters and path variables from the URI called


6. `@Provider`: Marks classes as JAX-RS providers, enabling them to handle exceptions, message body reading/writing, and
   other aspects of request and response processing.

7. `@DefaultValue`: Specifies default values for query parameters or form parameters.

These annotations empower developers to create RESTful web services efficiently, ensuring compliance with REST
principles. They are integral to JAX-RS applications, simplifying the development of web APIs in Java.