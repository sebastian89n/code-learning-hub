# spring-mvc

Example of spring-mvc(Model-View-Controller) usage.

Sample controllers, rest controllers and views to display data.

Examples are very simple and just for demonstration purposes only.

Basic UI in Thymeleaf+Bootstrap to show view aspect.

Spring Boot uses convention over configuration approach so a lot of things are pre-cofnigured like Thymeleaf template
engine or Jackson.

Injects spring-data-jpa module to get pre-defined services, repositories, data etc.

Server deploys on localhost:8080

H2 console:
http://localhost:8080/h2-console

JDBC url visible in the logs during server startup:

2023-10-01 19:49:58.966 INFO 11276 --- [  restartedMain] o.s.b.a.h2.H2ConsoleAutoConfiguration    : H2 console
availableat '/h2-console'. Database available at '**jdbc:h2:mem:89b72fce-cbe4-4c68-914d-ab02839e739a**'

