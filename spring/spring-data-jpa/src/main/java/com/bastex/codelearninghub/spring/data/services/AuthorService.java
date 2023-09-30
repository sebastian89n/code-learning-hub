package com.bastex.codelearninghub.spring.data.services;


import com.bastex.codelearninghub.spring.data.domain.Author;
import com.bastex.codelearninghub.spring.data.domain.dto.AuthorDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AuthorService {
    void save(Author author);

    Page<AuthorDTO> findAll(final Pageable page);

    long count();
}
