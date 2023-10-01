package com.bastex.codelearninghub.spring.data.domain.projections;

public interface AuthorProjection extends BaseEntityProjection {
    String getEmail();

    String getFirstName();

    String getLastName();
}
