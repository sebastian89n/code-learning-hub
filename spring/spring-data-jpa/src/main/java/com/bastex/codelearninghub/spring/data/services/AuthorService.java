package com.bastex.codelearninghub.spring.data.services;


import com.bastex.codelearninghub.spring.data.domain.Author;
import com.bastex.codelearninghub.spring.data.domain.projections.AuthorProjection;
import com.bastex.codelearninghub.spring.data.domain.query.AuthorSort;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface AuthorService {
    long save(Author author);

    Optional<AuthorProjection> findById(long authorId);

    Page<AuthorProjection> findAll(int page, int size, AuthorSort authorSort);

    long count();
}
