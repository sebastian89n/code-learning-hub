package com.bastex.codelearninghub.spring.data.services;


import com.bastex.codelearninghub.spring.data.domain.Book;
import com.bastex.codelearninghub.spring.data.domain.projections.BookIdIsbnProjection;
import com.bastex.codelearninghub.spring.data.domain.projections.BookProjection;
import com.bastex.codelearninghub.spring.data.domain.query.BookSearchDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BookService {
    void save(Book book);

    List<BookProjection> searchBooks(BookSearchDTO bookSearchDTO);

    Page<BookProjection> findAll(Pageable page);

    Page<BookProjection> findAllBooksByTitleContains(String title, Pageable page);

    Page<BookProjection> findAllBooksByPublisherName(String publisherName, Pageable page);

    Page<BookProjection> findAllBooksByAuthor(String firstName, String lastName, Pageable page);

    Optional<BookIdIsbnProjection> findBookIdIsbnByTitle(String title);

    Page<BookIdIsbnProjection> findAllBookIdIsbnByTitleLike(String title, Pageable page);

    List<BookIdIsbnProjection> findAllBookIdIsbnByTitleContainsAndPublicationDateAfter(String title, LocalDate publicationDate);

    long count();
}
