# Jakarta Servlets

Jakarta Servlets are a fundamental part of the Jakarta EE platform, providing a powerful and
flexible way to build dynamic, server-side web applications. Servlets are Java classes that handle requests and generate
responses in a web-based, distributed, and platform-independent environment.

**To access the application:** http://localhost:8080/servlets-app/

**Users are preconfigured in:** `users.properties`

The provided example offers a simple illustration of using servlets and filters within a Java web application. It
demonstrates the usage of these components in handling login functionality and serving static resources.

It's important to note that this is a basic demonstration designed to showcase how servlets and filters work together.
While it serves
as a starting point for understanding their usage, real-life applications typically involve more complex and diverse
features tailored to specific requirements.

## Key Concepts

1. **Servlet:** A Java class that extends the `javax.servlet.http.HttpServlet` class, responsible for processing HTTP
   requests and generating responses. Servlets can be used to create dynamic web content.

2. **Servlet Container:** Also known as the web container, it's part of a web server that manages the execution of
   servlets. Popular containers include Apache Tomcat, Jetty, and WildFly.

3. **Lifecycle:** Servlets have a well-defined lifecycle consisting of three main methods: `init()`, `service()`,
   and `destroy()`. These methods are called at different stages of a servlet's existence.

4. **HTTP Methods:** Servlets respond to HTTP methods such as GET, POST, PUT, and DELETE. The `doGet()` and `doPost()`
   methods are commonly overridden to handle these methods.

5. **Request and Response:** Servlets receive HTTP requests via the `HttpServletRequest` object and send responses via
   the `HttpServletResponse` object. These objects provide methods to access request parameters, headers, and generate
   responses.

6. **URL Mapping:** Servlets are mapped to specific URLs within a web application using the `@WebServlet` annotation or
   configuration in the web.xml file.

7. **Session Management:** Servlets can manage user sessions using `HttpSession` to store user-specific data across
   multiple requests.

8. **Filter:** Servlet Filters allow you to preprocess and postprocess requests and responses. They can be used to
   implement cross-cutting concerns like logging, authentication, and input validation.

9. **Listeners:** Servlet context listeners and session listeners provide mechanisms to detect changes in the web
   application's lifecycle.

## Configuration Methods for Servlets and Filters

### 1. web.xml Configuration

#### Description:

- Traditional XML-based configuration for servlets and filters in Jakarta EE (Java Platform, Enterprise Edition)
  applications.
- Requires the creation of a web.xml file in the WEB-INF directory.

### 2. Programmatic Registration

#### Description:

- Servlets and filters are registered programmatically in Java code using ServletContext and FilterRegistration classes.
- Introduced in Servlet 3.0 specification.

### 3. Annotations (e.g., @WebServlet, @WebFilter)

#### Description:

- Annotations are introduced in the Servlet 3.0 specification for declarative registration of servlets and filters.
- Annotations are applied directly to Java classes.
- Cannot specify filter order with @WebFilter (order may be container-specific).
- May lack the fine-grained control of XML-based configuration.

