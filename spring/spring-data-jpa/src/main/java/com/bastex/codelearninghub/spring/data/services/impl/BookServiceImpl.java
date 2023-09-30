package com.bastex.codelearninghub.spring.data.services.impl;

import com.bastex.codelearninghub.spring.data.domain.Book;
import com.bastex.codelearninghub.spring.data.domain.dto.BookDTO;
import com.bastex.codelearninghub.spring.data.repositories.BookRepository;
import com.bastex.codelearninghub.spring.data.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    @Transactional(readOnly = false)
    public void save(final Book book) {
        bookRepository.save(book);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<BookDTO> findAll(final Pageable page) {
        return bookRepository.findAllBooks(page);
    }

    @Override
    @Transactional(readOnly = true)
    public long count() {
        return bookRepository.count();
    }
}
