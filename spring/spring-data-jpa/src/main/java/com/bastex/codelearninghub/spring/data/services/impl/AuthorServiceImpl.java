package com.bastex.codelearninghub.spring.data.services.impl;

import com.bastex.codelearninghub.spring.data.domain.Author;
import com.bastex.codelearninghub.spring.data.domain.dto.AuthorDTO;
import com.bastex.codelearninghub.spring.data.repositories.AuthorRepository;
import com.bastex.codelearninghub.spring.data.services.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    @Override
    @Transactional(readOnly = false)
    public void save(final Author author) {
        authorRepository.save(author);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<AuthorDTO> findAll(final Pageable page) {
        return authorRepository.findAllAuthors(page);
    }

    @Override
    @Transactional(readOnly = true)
    public long count() {
        return authorRepository.count();
    }
}
