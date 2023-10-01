package com.bastex.codelearninghub.spring.data.domain.projections;

import java.time.LocalDate;

public interface BookProjection extends BaseEntityProjection {
    String getTitle();

    String getIsbn();

    LocalDate getPublicationDate();

    String getPublisherName();
}
