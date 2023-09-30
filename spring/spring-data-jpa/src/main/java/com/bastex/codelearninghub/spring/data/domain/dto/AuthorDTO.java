package com.bastex.codelearninghub.spring.data.domain.dto;

public interface AuthorDTO extends BaseEntityDTO {
    String getEmail();

    String getFirstName();

    String getLastName();
}
