package com.bastex.codelearninghub.spring.data.services;


import com.bastex.codelearninghub.spring.data.domain.Book;
import com.bastex.codelearninghub.spring.data.domain.projections.BookIdIsbnProjection;
import com.bastex.codelearninghub.spring.data.domain.projections.BookProjection;
import com.bastex.codelearninghub.spring.data.domain.query.BookSearchQuery;
import com.bastex.codelearninghub.spring.data.domain.query.BookSort;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface BookDataService {
    long save(Book book);

    int updatePublicationDateByBookIds(LocalDate newPublicationDate, Set<Long> bookIds);

    List<BookProjection> searchBooks(BookSearchQuery bookSearchQuery);

    Optional<BookProjection> findById(long bookId);

    Page<BookProjection> findAll(int page, int size, BookSort bookSort);

    Page<BookProjection> findAllBooksByTitleContains(String title, int page, int size, BookSort bookSort);

    Page<BookProjection> findAllBooksByPublisherName(String publisherName, int page, int size, BookSort bookSort);

    Page<BookProjection> findAllBooksByAuthor(String firstName, String lastName, int page, int size, BookSort bookSort);

    Optional<BookIdIsbnProjection> findBookIdIsbnByTitle(String title);

    Page<BookIdIsbnProjection> findAllBookIdIsbnByTitleLike(String title, int page, int size, BookSort bookSort);

    List<BookIdIsbnProjection> findAllBookIdIsbnByTitleContainsAndPublicationDateAfter(String title, LocalDate publicationDate);

    long count();
}
