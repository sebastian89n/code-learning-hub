# liquibase

Example of Liquibase scripts and code to execute them programmatically via separate jar.

It uses Spring Boot to automatically execute the configured scripts.

It can be also done by hand by using liquibase.Liquibase class.

It can be run against h2 or postgres depending on the application.properties(jdbc url etc.).
It also works with other db types but requires proper driver to be provided.

By the default if no context is provided, Liquibase will run every changeset.
So we provide dummy context(can be any name) to initialize only default changesets(without any context specified).
initDataScript context will execute changesets to initialize data via Liquibase inserts.

To test local postgres download zip from:
https://www.enterprisedb.com/download-postgresql-binaries

From bin folder:

- initdb.exe -D ../data --username=postgres --auth=trust (initializes db)
- pg_ctl.exe start -D ../data (starts db)
- psql --username postgres (logs into console)

Afterward we need to create db configured in jdbc url in psql
CREATE DATABASE testdb
\c testdb (to switch to that db inside the console)
