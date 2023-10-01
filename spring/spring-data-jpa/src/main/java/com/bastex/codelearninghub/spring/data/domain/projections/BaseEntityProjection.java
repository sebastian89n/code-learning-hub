package com.bastex.codelearninghub.spring.data.domain.projections;

import java.time.Instant;

public interface BaseEntityProjection {
    Long getId();

    Instant getCreatedTimestamp();

    Instant getLastUpdatedTimestamp();
}
