package com.bastex.codelearninghub.spring.data.domain.dto;

import java.time.LocalDate;

public interface BookDTO extends BaseEntityDTO {
    String getTitle();

    String getIsbn();

    LocalDate getPublicationDate();

    String getPublisherName();
}
