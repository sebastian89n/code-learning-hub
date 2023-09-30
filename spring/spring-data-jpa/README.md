# spring-data-jpa

Example of spring-data-jpa usage and JPA mapping.

Some important points:

### Repositories - interfaces

- CrudRepository mainly provides CRUD functions.

- PagingAndSortingRepository provides methods to do pagination and sorting records.

- JpaRepository provides some JPA-related methods such as flushing the persistence context and deleting records in a
  batch.

### @Repository annotation

Repository annotation is optional annotation but causes Spring to do exception translation.
It will catch all JDBC/JPA/Hibernate/ORM impl exceptions and re-throw DataAccessException