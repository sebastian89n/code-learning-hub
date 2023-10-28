# Spring Data JPA: Simplifying Data Access with JPA

Spring Data JPA is a module within the Spring ecosystem that simplifies data access in Java applications by building
upon the Java Persistence API (JPA). It provides a higher-level, more expressive interface for working with relational
databases, reducing the need for boilerplate code and promoting best practices in data access.

## Overview

Spring Data JPA offers a range of features and annotations to streamline data access operations and simplify database
interaction:

### Key Features

- **Repository Interfaces:** Spring Data JPA provides repository interfaces that extend the `CrudRepository`
  or `PagingAndSortingRepository` interfaces. These interfaces offer a wide range of methods for common data access
  operations, reducing the need to write repetitive code.

- **Query Methods:** Developers can create queries for database operations using method names and query DSLs, providing
  a more expressive and type-safe way to define queries.

- **Custom Queries:** It supports the creation of custom queries using the `@Query` annotation, allowing developers to
  define complex database queries directly in their Java code.

- **Pagination and Sorting:** Spring Data JPA simplifies pagination and sorting for query results, making it easy to
  retrieve data in manageable chunks.

- **Domain Object Mapping:** Spring Data JPA supports the mapping of Java domain objects to database tables using JPA
  annotations, simplifying object-relational mapping.

- **Auditing:** It provides automatic auditing capabilities, including the ability to track the creation and
  modification of entities, which is helpful in scenarios like audit trails.

## Repositories - interfaces

- `CrudRepository` mainly provides CRUD functions.

- `PagingAndSortingRepository` provides methods to do pagination and sorting records.

- `JpaRepository` provides some JPA-related methods like flushing the persistence context or deleting records in a
  batch.

## @Repository annotation

Marking Repository interface with `@Repository` annotation is optional, but it has an advantage. If annotation is
present Spring will do exception translation.
It will catch all JDBC/JPA/Hibernate/ORM exceptions and re-throw `DataAccessException`.