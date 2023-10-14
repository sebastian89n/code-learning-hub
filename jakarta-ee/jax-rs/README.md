# jax-rs

Examples of JAX-RS specification using Jersey implementation. Uses Grizzly server to run the examples.

e.g. curls

curl -i localhost:8080/api/feedbacks -X PUT -H 'Content-Type: application/json' -H 'Accept: application/json' --data '{"
userId":"user123","text": "Some feedback"}'

curl -i -X GET localhost:8080/api/feedbacks -H 'Accept: application/json'

curl -i -X GET localhost:8080/api/feedbacks/1 -H 'Accept: application/json'

curl -i -X DELETE localhost:8080/api/feedbacks/1 -H 'Accept: application/json'

Jakarta RESTful Web Services, (JAX-RS; formerly Java API for RESTful Web Services) is a Jakarta EE API specification
that provides support in creating web services according to the Representational State Transfer (REST) architectural
pattern. JAX-RS uses annotations, introduced in Java SE 5, to simplify the development and deployment of web service
clients and endpoints.

Specification
JAX-RS provides some annotations to aid in mapping a resource class (a POJO) as a web resource. The annotations use the
Java package jakarta.ws.rs (previously was javax.ws.rs but was renamed on May 19, 2019). They include:

- **@Path** specifies the relative path for a resource class or method.
- **@GET**, **@PUT**, **@POST**, **@DELETE** and **@HEAD** specify the HTTP request type of a resource.
- **@Produces** specifies the response Internet media types (used for content negotiation).
- **@Consumes** specifies the accepted request Internet media types.

In addition, it provides further annotations to method parameters to pull information out of the request. All the @*
Param annotations take a key of some form which is used to look up the value required.

- **@PathParam** binds the method parameter to a path segment.


- **@QueryParam** binds the method parameter to the value of an HTTP query parameter.


- **@MatrixParam** binds the method parameter to the value of an HTTP matrix parameter.


- **@HeaderParam** binds the method parameter to an HTTP header value.


- **@CookieParam** binds the method parameter to a cookie value.


- **@FormParam** binds the method parameter to a form value.


- **@DefaultValue** specifies a default value for the above bindings when the key is not found.


- **@Context returns** the entire context of the object (for example @Context HttpServletRequest request).

With @Context param you can inject:

- SecurityContext – Security context instance for the current HTTP request
- Request – Used for setting precondition request processing
- Application, Configuration, and Providers -> Provide access to the JAX-RS application, configuration, and providers
  instances
- ResourceContext – Resource context class instances
- ServletConfig – The ServletConfig instance instance
- ServletContext – The ServletContext instance
- HttpServletRequest – The HttpServletRequest instance for the current request
- HttpServletResponse – The HttpServletResponse instance for the current request
- HttpHeaders – Maintains the HTTP header keys and values
- UriInfo – Query parameters and path variables from the URI called

