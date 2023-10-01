package com.bastex.codelearninghub.spring.data.services.impl;

import com.bastex.codelearninghub.spring.data.domain.Author;
import com.bastex.codelearninghub.spring.data.domain.projections.AuthorProjection;
import com.bastex.codelearninghub.spring.data.repositories.AuthorRepository;
import com.bastex.codelearninghub.spring.data.services.AuthorService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    @Override
    @Transactional(readOnly = false)
    public void save(@NonNull final Author author) {
        authorRepository.save(author);
    }

    @Override
    @Transactional(readOnly = false)
    public Optional<AuthorProjection> findById(final long authorId) {
        return authorRepository.findAuthorById(authorId);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<AuthorProjection> findAll(@NonNull final Pageable page) {
        return authorRepository.findAllAuthorsBy(page);
    }

    @Override
    @Transactional(readOnly = true)
    public long count() {
        return authorRepository.count();
    }
}
