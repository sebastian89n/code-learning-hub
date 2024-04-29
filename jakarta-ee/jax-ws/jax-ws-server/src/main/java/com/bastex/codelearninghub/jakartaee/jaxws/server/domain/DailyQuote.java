package com.bastex.codelearninghub.jakartaee.jaxws.server.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DailyQuote {
    private Long id;

    private String quote;

    private String author;

    private String userId;

    private Instant createdTimestamp;
}
