# liquibase

Example of Liquibase scripts and code to execute them programmatically via separate jar.

It is a bit more complex example with Spring Boot autoconfiguration disabled. It demonstrates how we can configure
it manually to enable Spring context for custom migrations in the code.

It can be run against h2 or postgres depending on the application.properties(jdbc url etc.).
It also works with other db types but requires proper driver to be provided in the pom / classpath.

By the default if no context is provided, Liquibase will run every changeset.
So we provide dummy context called "update" to initialize only default changesets(those without any context specified).
initDataScript context will execute changesets to insert sample data via Liquibase inserts.
initDataCode context will initialize sample data via code

To test local postgres download zip from:
https://www.enterprisedb.com/download-postgresql-binaries

From bin folder:

- initdb.exe -D ../data --username=postgres --auth=trust (initializes db)
- pg_ctl.exe start -D ../data (starts db)
- psql --username postgres (logs into console)

Afterward we need to create db configured in jdbc url in psql
CREATE DATABASE testdb
\c testdb (to switch to that db inside the console)
