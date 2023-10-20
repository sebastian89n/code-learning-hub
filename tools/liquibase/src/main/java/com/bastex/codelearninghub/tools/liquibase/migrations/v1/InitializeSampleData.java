package com.bastex.codelearninghub.tools.liquibase.migrations.v1;

import com.bastex.codelearninghub.spring.data.bootstrap.DataLoader;
import com.bastex.codelearninghub.spring.data.services.AuthorDataService;
import com.bastex.codelearninghub.spring.data.services.BookDataService;
import com.bastex.codelearninghub.spring.data.services.PublisherDataService;
import com.bastex.codelearninghub.tools.liquibase.contexthelper.AppContextHolder;
import com.bastex.codelearninghub.tools.liquibase.contexthelper.CustomSpringBeanTaskChange;
import liquibase.database.Database;
import liquibase.exception.ValidationErrors;
import liquibase.resource.ResourceAccessor;

/**
 * Requires no args constructor for Liquibase.
 */
public class InitializeSampleData implements CustomSpringBeanTaskChange {
    private final AuthorDataService authorDataService;

    private final BookDataService bookDataService;

    private final PublisherDataService publisherDataService;

    public InitializeSampleData() {
        this.authorDataService = AppContextHolder.INSTANCE.getContext().getBean(AuthorDataService.class);
        this.bookDataService = AppContextHolder.INSTANCE.getContext().getBean(BookDataService.class);
        this.publisherDataService = AppContextHolder.INSTANCE.getContext().getBean(PublisherDataService.class);
    }

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
