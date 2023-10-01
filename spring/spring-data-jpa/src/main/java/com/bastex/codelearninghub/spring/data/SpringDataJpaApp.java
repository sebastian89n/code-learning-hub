package com.bastex.codelearninghub.spring.data;

import com.bastex.codelearninghub.spring.data.domain.projections.BookIdIsbnProjection;
import com.bastex.codelearninghub.spring.data.domain.projections.BookProjection;
import com.bastex.codelearninghub.spring.data.domain.query.BookSearchQuery;
import com.bastex.codelearninghub.spring.data.services.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@Slf4j
public class SpringDataJpaApp {
    public static void main(final String[] args) {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringDataJpaApp.class, args);

        final BookService bookService = applicationContext.getBean(BookService.class);
        testQueries(bookService);
    }

    private static void testQueries(final BookService bookService) {
        log.info("-- bookService.findAll");
        final Sort sortBy = Sort.by("lastUpdatedTimestamp").descending().and(Sort.by("title"));
        final Page<BookProjection> books = bookService.findAll(PageRequest.of(0, 10, sortBy));
        books.forEach(SpringDataJpaApp::logBook);

        log.info("-- bookService.findBookIdIsbnByTitle");
        final Optional<BookIdIsbnProjection> bookIdIsbnByTitle = bookService.findBookIdIsbnByTitle("Algorithms, 4th Edition");
        bookIdIsbnByTitle.ifPresentOrElse(SpringDataJpaApp::logBookIdIsbn, () -> log.warn("Book not found"));

        log.info("-- bookService.findAllBookIdIsbnByTitleLike");
        final Page<BookIdIsbnProjection> algorithmsBooks = bookService.findAllBookIdIsbnByTitleLike("Algorithms%", PageRequest.of(0, 10));
        algorithmsBooks.forEach(SpringDataJpaApp::logBookIdIsbn);

        log.info("-- bookService.findAllBookIdIsbnByTitleContainsAndPublicationDateAfter");
        final List<BookIdIsbnProjection> algorithms = bookService.findAllBookIdIsbnByTitleContainsAndPublicationDateAfter("Algorithms", LocalDate.of(2017, 1, 1));
        algorithms.forEach(SpringDataJpaApp::logBookIdIsbn);

        log.info("-- bookService.searchBooks");
        final BookSearchQuery bookSearchQuery = BookSearchQuery.builder()
                .title("Algorithms, 4th Edition")
                .build();

        final List<BookProjection> bookProjections = bookService.searchBooks(bookSearchQuery);
        bookProjections.forEach(SpringDataJpaApp::logBook);

        log.info("-- bookService.findAllBooksByAuthor");
        final Page<BookProjection> allBooksByAuthor = bookService.findAllBooksByAuthor("Robert", "Sedgewick", PageRequest.of(0, 10));
        allBooksByAuthor.forEach(SpringDataJpaApp::logBook);
    }

    private static void logBook(final BookProjection book) {
        log.info("Id: {}, Title: {}, isbn: {}, publication date: {}, publisher name: {}", book.getId(), book.getTitle(), book.getIsbn(), book.getPublicationDate(), book.getPublisherName());
    }

    private static void logBookIdIsbn(final BookIdIsbnProjection bookIdIsbnProjection) {
        log.info("Id: {}, isbn: {}", bookIdIsbnProjection.getId(), bookIdIsbnProjection.getIsbn());
    }
}
