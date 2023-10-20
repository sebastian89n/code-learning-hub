package com.bastex.codelearninghub.tools.liquibase;

import liquibase.Contexts;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Slf4j
@Service
class DbMigrationService {
    @SneakyThrows({SQLException.class, DatabaseException.class})
    void executeMigration(final String dbUrl, final String dbSchema, final String dbUsername, final String dbPassword, final String contexts) {
        try (final Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) {
            final Database database = DatabaseFactory.getInstance()
                    .findCorrectDatabaseImplementation(new JdbcConnection(connection));

            initializeSchemaEnv(dbSchema);
            upgradeDatabase(database, contexts);
        }
    }

    @SneakyThrows(LiquibaseException.class)
    private void upgradeDatabase(final Database database, final String contexts) {
        final String dbChangeLogLocation = "classpath:db/changelog/db.changelog-master.xml";
        try (final Liquibase liquibase = new Liquibase(dbChangeLogLocation, new ClassLoaderResourceAccessor(this.getClass().getClassLoader()), database)) {
            log.info("Starting database migration...");
            liquibase.update(new Contexts());
            log.info("Migration finished successfully");
        }
    }

    private static void initializeSchemaEnv(final String dbSchema) {
        if (StringUtils.isNotBlank(dbSchema)) {
            System.setProperty("schemaName", dbSchema);
            System.setProperty("schemaName.", dbSchema);
        } else {
            System.setProperty("schemaName", "");
            System.setProperty("schemaName.", "");
        }
    }
}
