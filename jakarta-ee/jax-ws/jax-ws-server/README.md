# jax-ws-server

Server publish the service on: `http://localhost:8080/DailyQuotesService`

WSDL: `http://localhost:8080/DailyQuotesService?wsdl`

XSD: `http://localhost:8080/DailyQuotesService?xsd=1`

JAX-WS uses JAXB to map messages.

Example of Bottom-Up approach - WSDL is generated from Java classes mapped with JAX-WS annotations.

Top-Down is when you generate Java code from existing WSDL.

It can be tested using jax-ws-client or by using some external tool like SoapUI(I recommend to check it out, it is a
great tool).