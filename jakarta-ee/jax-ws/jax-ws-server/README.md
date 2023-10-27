# jax-ws-server

JAX-WS - Jakarta XML Web Services(previously Java API for XML Web Services) is a standardized API for creating and
consuming SOAP (Simple Object Access Protocol) web services.

Server publish the service on: http://localhost:8080/DailyQuotesService

WSDL: http://localhost:8080/DailyQuotesService?wsdl

XSD: http://localhost:8080/DailyQuotesService?xsd=1

JAX-WS uses JAXB to map messages.

Example of Bottom-Up approach - WSDL is generated from Java classes mapped with JAX-WS annotations.

Top-Down is when you generate Java code from existing WSDL.