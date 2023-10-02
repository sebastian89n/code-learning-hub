package com.bastex.codelearninghub.spring.data.services.impl;

import com.bastex.codelearninghub.spring.data.domain.Author;
import com.bastex.codelearninghub.spring.data.domain.projections.AuthorProjection;
import com.bastex.codelearninghub.spring.data.domain.query.AuthorSort;
import com.bastex.codelearninghub.spring.data.repositories.AuthorRepository;
import com.bastex.codelearninghub.spring.data.services.AuthorDataService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
class AuthorDataServiceImpl implements AuthorDataService {
    private final AuthorRepository authorRepository;

    @Override
    @Transactional(readOnly = false)
    public long save(@NonNull final Author author) {
        return authorRepository.save(author).getId();
    }

    @Override
    @Transactional(readOnly = false)
    public Optional<AuthorProjection> findById(final long authorId) {
        return authorRepository.findAuthorById(authorId);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<AuthorProjection> findAll(final int page, final int size, @NonNull final AuthorSort authorSort) {
        return authorRepository.findAllAuthorsBy(PageRequest.of(page, size, authorSort.getSort()));
    }

    @Override
    @Transactional(readOnly = true)
    public long count() {
        return authorRepository.count();
    }
}
