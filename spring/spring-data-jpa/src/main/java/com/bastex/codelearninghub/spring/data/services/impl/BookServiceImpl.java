package com.bastex.codelearninghub.spring.data.services.impl;

import com.bastex.codelearninghub.spring.data.domain.Book;
import com.bastex.codelearninghub.spring.data.domain.projections.BookIdIsbnProjection;
import com.bastex.codelearninghub.spring.data.domain.projections.BookProjection;
import com.bastex.codelearninghub.spring.data.domain.query.BookSearchQuery;
import com.bastex.codelearninghub.spring.data.repositories.BookRepository;
import com.bastex.codelearninghub.spring.data.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
    public List<BookProjection> searchBooks(final BookSearchQuery bookSearchQuery) {
        return bookRepository.searchBooks(bookSearchQuery);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<BookProjection> findAll(final Pageable page) {
        return bookRepository.findAllBooks(page);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<BookProjection> findAllBooksByTitleContains(final String title, final Pageable page) {
        return bookRepository.findAllBooksByTitleContains(title, page);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<BookProjection> findAllBooksByPublisherName(final String publisherName, final Pageable page) {
        return bookRepository.findAllBooksByPublisherName(publisherName, page);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<BookProjection> findAllBooksByAuthor(final String firstName, final String lastName, final Pageable page) {
        return bookRepository.findAllBooksByAuthor(firstName, lastName, page);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<BookIdIsbnProjection> findBookIdIsbnByTitle(final String title) {
        return bookRepository.findBookIdIsbnByTitle(title);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<BookIdIsbnProjection> findAllBookIdIsbnByTitleLike(final String title, final Pageable page) {
        return bookRepository.findAllBookIdIsbnByTitleLike(title, page);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BookIdIsbnProjection> findAllBookIdIsbnByTitleContainsAndPublicationDateAfter(final String title, final LocalDate publicationDate) {
        return bookRepository.findAllBookIdIsbnByTitleContainsAndPublicationDateGreaterThan(title, publicationDate);
    }

    @Override
    @Transactional(readOnly = true)
    public long count() {
        return bookRepository.count();
    }
}
