## Liquibase: Database Version Control and Migration

Module contains example of Liquibase scripts and Java code to execute them programmatically.

In this example, we use Liquibase embedded in Java application with Spring Boot autoconfiguration disabled. It
demonstrates how we can configure
it manually to enable Spring context for custom migrations in the code.

It can be run against `h2` or `postgres` depending on the application.properties(jdbc url etc.).
It also works with other db types but requires proper driver to be provided in the pom / classpath.

By the default if no context is provided, Liquibase will run every changeset.
So we provide dummy context called "update" to initialize only default changesets(those without any context specified).

`initDataScript` context executes changesets to insert sample data via Liquibase inserts.

`initDataCode` context executes sample data initialization via code

To test local postgres download zip from:
https://www.enterprisedb.com/download-postgresql-binaries

From bin folder:

- `initdb.exe -D ../data --username=postgres --auth=trust` - initializes db
- `pg_ctl.exe start -D ../data` - starts the database
- `psql --username postgres` - open DB console

We need to create db configured in jdbc url in psql.

Open DB console and run:

`CREATE DATABASE testdb`

`\c testdb` - to switch to that db inside the console

## Overview

Liquibase is an open-source database version control and migration tool that simplifies the process of managing database
changes and schema evolution. It allows developers to define database changes in a structured and versioned way,
ensuring consistent and trackable updates to the database schema over time. Liquibase is widely used in software
development to streamline database management and ensure the reliability of database deployments.

Liquibase offers a range of features and concepts that make it a valuable tool for managing database changes:

### Key Features

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
