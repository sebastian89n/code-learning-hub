package com.bastex.codelearninghub.spring.data.domain.projections;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.Instant;
import java.time.LocalDate;

@RequiredArgsConstructor
@Getter
@ToString
public class BookProjectionImpl implements BookProjection {
    private final Long id;

    private final Instant createdTimestamp;

    private final Instant lastUpdatedTimestamp;

    private final String title;

    private final String isbn;

    private final LocalDate publicationDate;

    private final String publisherName;
}
