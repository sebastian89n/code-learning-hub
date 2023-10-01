package com.bastex.codelearninghub.spring.mvc.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {
    private Long id;

    private Instant createdTimestamp;

    private Instant lastUpdatedTimestamp;

    private String title;

    private String isbn;

    private LocalDate publicationDate;

    private String publisherName;
}
