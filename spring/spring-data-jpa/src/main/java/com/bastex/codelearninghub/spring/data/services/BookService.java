package com.bastex.codelearninghub.spring.data.services;


import com.bastex.codelearninghub.spring.data.domain.Book;
import com.bastex.codelearninghub.spring.data.domain.projections.BookIdIsbnProjection;
import com.bastex.codelearninghub.spring.data.domain.projections.BookProjection;
import com.bastex.codelearninghub.spring.data.domain.query.BookSearchQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface BookService {
    void save(Book book);

    int updatePublicationDateByBookIds(LocalDate newPublicationDate, Set<Long> bookIds);

    List<BookProjection> searchBooks(BookSearchQuery bookSearchQuery);

    Optional<BookProjection> findById(long bookId);

    Page<BookProjection> findAll(Pageable page);

    Page<BookProjection> findAllBooksByTitleContains(String title, Pageable page);

    Page<BookProjection> findAllBooksByPublisherName(String publisherName, Pageable page);

    Page<BookProjection> findAllBooksByAuthor(String firstName, String lastName, Pageable page);

    Optional<BookIdIsbnProjection> findBookIdIsbnByTitle(String title);

    Page<BookIdIsbnProjection> findAllBookIdIsbnByTitleLike(String title, Pageable page);

    List<BookIdIsbnProjection> findAllBookIdIsbnByTitleContainsAndPublicationDateAfter(String title, LocalDate publicationDate);

    long count();
}
