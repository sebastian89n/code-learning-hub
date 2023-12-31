package com.bastex.codelearninghub.tools.liquibase.migrations.v1;

import com.bastex.codelearninghub.spring.data.bootstrap.DataLoader;
import com.bastex.codelearninghub.spring.data.services.AuthorDataService;
import com.bastex.codelearninghub.spring.data.services.BookDataService;
import com.bastex.codelearninghub.spring.data.services.PublisherDataService;
import com.bastex.codelearninghub.tools.liquibase.contexthelper.LiquibaseInitializedSpringAwareMigration;
import liquibase.database.Database;
import liquibase.exception.ValidationErrors;
import liquibase.resource.ResourceAccessor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Requires no args constructor for Liquibase to be able to initialize it.
 * \@Autowired fields are initialized because LiquibaseInitializedSpringMigration register this class as Spring bean.
 */
@NoArgsConstructor
public class PopulateDbWithSampleDataMigration implements LiquibaseInitializedSpringAwareMigration {

    @Autowired
    private AuthorDataService authorDataService;

    @Autowired
    private BookDataService bookDataService;

    @Autowired
    private PublisherDataService publisherDataService;

    @Override
    public void execute(final Database database) {
        // Reuses class from Spring Data JPA module
        final DataLoader dataLoader = new DataLoader(authorDataService, bookDataService, publisherDataService);
        dataLoader.run();
    }

    @Override
    public String getConfirmationMessage() {
        return null;
    }

    @Override
    public void setFileOpener(final ResourceAccessor resourceAccessor) {
    }

    @Override
    public ValidationErrors validate(final Database database) {
        return null;
    }
}
