package com.bastex.codelearninghub.tools.liquibase.migrations;

import com.bastex.codelearninghub.tools.liquibase.beans.LiquibaseConfig;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Slf4j
@Service
@RequiredArgsConstructor
class DbMigrationServiceImpl implements DbMigrationService {
    private final LiquibaseConfig liquibaseConfig;

    @Override
    @SneakyThrows({SQLException.class, DatabaseException.class})
    public void runMigration() {
        try (final Connection connection = DriverManager.getConnection(liquibaseConfig.url(),
                liquibaseConfig.username(),
                liquibaseConfig.password())) {

            final Database database = DatabaseFactory.getInstance()
                    .findCorrectDatabaseImplementation(new JdbcConnection(connection));

            initializeSchemaEnv(liquibaseConfig.dbSchema());
            upgradeDatabase(database, liquibaseConfig.contextsToRun());
        }
    }

    @SneakyThrows(LiquibaseException.class)
    private void upgradeDatabase(final Database database, final String contexts) {
        try (final Liquibase liquibase = new Liquibase(liquibaseConfig.dbChangeLogLocation(), new ClassLoaderResourceAccessor(this.getClass().getClassLoader()), database)) {
            log.info("Starting database migration...");
            liquibase.update(contexts);
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
