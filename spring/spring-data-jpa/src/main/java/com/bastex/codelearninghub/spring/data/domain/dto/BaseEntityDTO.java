package com.bastex.codelearninghub.spring.data.domain.dto;

import java.time.Instant;

public interface BaseEntityDTO {
    Long getId();

    Instant getCreatedTimestamp();

    Instant getLastUpdatedTimestamp();
}
