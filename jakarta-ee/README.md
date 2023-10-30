# Modules

Modules with examples of some core Jakarta EE technologies:

- **jax-rs** - Jakarta RESTful Web Services
- **jax-ws** - Jakarta XML Web Services
- **jaxb** - Jakarta XML Binding
- **servlets** - Jakarta Servlets

## Jakarta EE (previously Java EE - Java Enterprise Edition)

Jakarta EE is a set of specifications and APIs for building and deploying
enterprise-level, distributed, and scalable Java applications. It provides a standardized and robust platform for
developing server-side applications, often used in business and enterprise environments.

## Overview

Jakarta EE is designed to simplify the development of large-scale, multi-tier, and enterprise-level applications. It
abstracts many low-level complexities and offers a set of standardized APIs and components to address common enterprise
challenges. Key features and technologies in Jakarta EE include:

### Common Jakarta EE Technologies

1. **Servlets:** Servlets are Java components that handle HTTP requests and provide dynamic web content. They are a
   fundamental building block of Java web applications.

2. **JSP (JavaServer Pages):** JSP is a technology that allows the creation of dynamic web pages using Java. It
   simplifies the generation of HTML content within Java web applications.

3. **Enterprise JavaBeans (EJB):** EJB provides a component-based approach to building server-side business logic,
   supporting features like transactions, security, and scalability.

4. **JPA (Java Persistence API):** JPA is a standard for Object-Relational Mapping (ORM) in Java, making it easier to
   interact with relational databases.

5. **JMS (Java Message Service):** JMS is an API for messaging, enabling asynchronous communication between distributed
   components in a Java application.

6. **JTA (Java Transaction API):** JTA provides support for distributed transactions, ensuring data consistency across
   multiple resources.

7. **CDI (Contexts and Dependency Injection):** CDI facilitates the management of beans, their lifecycle, and the
   injection of dependencies in a Jakarta EE application.

8. **JAX-WS (Jakarta XML Web Services):** JAX-WS enables the creation and consumption of SOAP-based web services in
   Jakarta EE applications, allowing seamless communication with external services.

9. **JAX-RS (Jakarta RESTful Web Services):** JAX-RS provides a framework for building RESTful web services in Jakarta
   EE, making it easy to create, expose, and consume RESTful APIs.

10. **JAXB (Jakarta XML Binding):** JAXB allows developers to map Java classes to XML schemas and vice
    versa. It simplifies the conversion of Java objects to XML (marshalling) and XML data to Java objects (
    unmarshalling)
    by using annotations or configuration files.

### Jakarta EE Containers

Jakarta EE applications are typically deployed in containers, which provide runtime environments for application
execution.
The two main types of containers are:

- **Web Containers:** These containers manage the execution of web applications, including Servlets, JSP, and related
  web components. Web containers are typically limited versions that include a subset of Jakarta EE technologies,
  focusing
  on web-related functionalities.

  **E.g. servers**: Apache Tomcat, Jetty


- **EJB Containers:** EJB containers host Enterprise JavaBeans and provide services like transaction management,
  security, and scalability.

  **E.g. servers**: Oracle Weblogic, WilfFly

## Notable Jakarta EE Implementations

Jakarta EE is just a specification with interfaces and rules defined in each module. Actual implementations are
provided by servers or external libraries. For example JAX-RS is implemented by Apache CXF, Jersey etc.

- **Oracle WebLogic Server:** A widely used Jakarta EE server that supports enterprise applications.
- **WildFly (formerly JBoss):** An open-source Jakarta EE server known for its speed and flexibility.
- **IBM WebSphere Application Server:** A Jakarta EE server with support for large-scale enterprise applications.

Jakarta EE has evolved, with the latest versions focusing on simplifying development, improving modularity, and
supporting
cloud-based deployment models.
