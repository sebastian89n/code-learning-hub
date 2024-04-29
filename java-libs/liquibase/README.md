# Liquibase

Liquibase is an open-source database version control and migration tool that simplifies the process of managing database
changes and schema evolution. It allows developers to define database changes in a structured and versioned way,
ensuring consistent and trackable updates to the database schema over time. Liquibase is widely used in software
development to streamline database management and ensure the reliability of database deployments.

## Key Features

- **Database-Agnostic:** Liquibase is database-agnostic, meaning it supports various database management systems, such
  as MySQL, PostgreSQL, Oracle, and more. Developers can use a single set of change sets to manage database schema
  changes across different database platforms.

- **Change Sets:** Change sets are XML or YAML files that define a specific database change, such as adding a table,
  modifying columns, or loading data. Change sets are versioned and can be executed in a specific order.

- **Version Control Integration:** Liquibase integrates with version control systems like Git, allowing database changes
  to be tracked and managed alongside application code.

- **Rollbacks:** Liquibase provides the ability to roll back database changes to previous states, making it possible to
  undo changes if needed.

- **Database Refactoring:** It supports database refactoring techniques, enabling developers to make structural
  improvements to the database while maintaining data integrity.

- **Changelog Management:** A changelog file lists the change sets and their execution order, making it easy to maintain
  and track changes over time.

## Usage

This module provides an illustrative example of using Liquibase scripts and Java code to execute them programmatically.
The focus is on embedding Liquibase in a Java application, with Spring Boot autoconfiguration deliberately disabled. The
intention is to demonstrate how to manually configure Liquibase to enable the Spring context for custom migrations
within the code.

The example allows execution against either an `h2` or `postgres` database, depending on
the configurations provided in the `application.properties` file (e.g., JDBC URL). While compatibility with other
database types is possible, it necessitates the inclusion of the appropriate driver in the project's `pom.xml` or
classpath.

By default, Liquibase will execute every changeset if no context is specified. To selectively run changesets, a dummy
context named "update" is provided, initializing only default changesets (those without any specific context).

### Contexts

- **update**: Initializes default changesets.
- **initDataScript**: Executes changesets to insert sample data using Liquibase inserts.
- **initDataCode**: Executes sample data initialization via code.

## Testing with Local PostgreSQL

To test with a local PostgreSQL database:

1. Download the PostgreSQL binaries zip from [EnterpriseDB](https://www.enterprisedb.com/download-postgresql-binaries).
2. Navigate to the `bin` folder in the downloaded archive.

- Run `initdb.exe -D ../data --username=postgres --auth=trust` to initialize the database.
- Start the database with `pg_ctl.exe start -D ../data`.
- Access the PostgreSQL console with `psql --username postgres`.

3. Within the console, create a database configured in the JDBC URL specified in `application.properties`:

   ```
   CREATE DATABASE testdb;
   \c testdb
   ```
