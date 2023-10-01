package com.bastex.codelearninghub.spring.data.services;


import com.bastex.codelearninghub.spring.data.domain.Author;
import com.bastex.codelearninghub.spring.data.domain.projections.AuthorProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface AuthorService {
    void save(Author author);

    Optional<AuthorProjection> findById(long authorId);

    Page<AuthorProjection> findAll(final Pageable page);

    long count();
}
