package com.bastex.codelearninghub.jakartaee.jaxws.server.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DailyQuote {
    private String quote;

    private String userId;

    private Instant createdTimestamp;
}
