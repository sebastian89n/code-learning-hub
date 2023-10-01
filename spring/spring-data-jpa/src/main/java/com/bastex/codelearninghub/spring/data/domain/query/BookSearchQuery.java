package com.bastex.codelearninghub.spring.data.domain.query;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class BookSearchQuery {
    private final String title;

    private final String isbn;

    private final LocalDate publicationDate;
}
