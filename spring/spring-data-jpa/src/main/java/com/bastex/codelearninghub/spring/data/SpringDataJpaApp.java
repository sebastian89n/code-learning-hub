package com.bastex.codelearninghub.spring.data;

import com.bastex.codelearninghub.spring.data.domain.projections.AuthorProjection;
import com.bastex.codelearninghub.spring.data.domain.projections.BookIdIsbnProjection;
import com.bastex.codelearninghub.spring.data.domain.projections.BookProjection;
import com.bastex.codelearninghub.spring.data.domain.query.AuthorSort;
import com.bastex.codelearninghub.spring.data.domain.query.BookSearchQuery;
import com.bastex.codelearninghub.spring.data.domain.query.BookSort;
import com.bastex.codelearninghub.spring.data.services.AuthorService;
import com.bastex.codelearninghub.spring.data.services.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@SpringBootApplication
@Slf4j
public class SpringDataJpaApp {
    public static void main(final String[] args) {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringDataJpaApp.class, args);

        final BookService bookService = applicationContext.getBean(BookService.class);
        testBookQueries(bookService);

        final AuthorService authorService = applicationContext.getBean(AuthorService.class);
        testAuthorQueries(authorService);
    }

    private static void testBookQueries(final BookService bookService) {
        log.info("-- bookService.findAll");
        final Page<BookProjection> books = bookService.findAll(0, 10, BookSort.idAscending);
        books.forEach(SpringDataJpaApp::logBook);

        log.info("-- bookService.findBookIdIsbnByTitle");
        final Optional<BookIdIsbnProjection> bookIdIsbnByTitle = bookService.findBookIdIsbnByTitle("Algorithms, 4th Edition");
        bookIdIsbnByTitle.ifPresentOrElse(SpringDataJpaApp::logBookIdIsbn, () -> log.warn("Book not found"));

        log.info("-- bookService.findById");
        final Optional<BookProjection> bookProjection = bookService.findById(books.getContent().get(0).getId());
        bookProjection.ifPresentOrElse(SpringDataJpaApp::logBook, () -> log.warn("Book not found"));

        log.info("-- bookService.findAllBookIdIsbnByTitleLike");
        final Page<BookIdIsbnProjection> algorithmsBooks = bookService.findAllBookIdIsbnByTitleLike("Algorithms%", 0, 10, BookSort.idAscending);
        algorithmsBooks.forEach(SpringDataJpaApp::logBookIdIsbn);

        log.info("-- bookService.findAllBookIdIsbnByTitleContainsAndPublicationDateAfter");
        final List<BookIdIsbnProjection> algorithms = bookService.findAllBookIdIsbnByTitleContainsAndPublicationDateAfter("Algorithms", LocalDate.of(2017, 1, 1));
        algorithms.forEach(SpringDataJpaApp::logBookIdIsbn);

        log.info("-- bookService.searchBooks");
        final BookSearchQuery bookSearchQuery = BookSearchQuery.builder().title("Algorithms, 4th Edition").build();

        final List<BookProjection> bookProjections = bookService.searchBooks(bookSearchQuery);
        bookProjections.forEach(SpringDataJpaApp::logBook);

        log.info("-- bookService.findAllBooksByAuthor");
        final Page<BookProjection> allBooksByAuthor = bookService.findAllBooksByAuthor("Robert", "Sedgewick", 0, 10, BookSort.idAscending);
        allBooksByAuthor.forEach(SpringDataJpaApp::logBook);

        log.info("-- bookService.findAllBooksByAuthor");
        final Set<Long> idsToUpdate = allBooksByAuthor.stream().map(BookProjection::getId).collect(Collectors.toUnmodifiableSet());
        final int updated = bookService.updatePublicationDateByBookIds(LocalDate.of(2023, 1, 1), idsToUpdate);
        log.info("Updated {} books", updated);
    }

    private static void testAuthorQueries(final AuthorService authorService) {
        log.info("-- authorService.findAll");
        final Page<AuthorProjection> allAuthors = authorService.findAll(0, 10, AuthorSort.idAscending);
        allAuthors.forEach(SpringDataJpaApp::logAuthor);
        final AuthorProjection authorProjection = allAuthors.getContent().get(0);

        log.info("-- authorService.findById");
        final Optional<AuthorProjection> authorById = authorService.findById(authorProjection.getId());
        authorById.ifPresentOrElse(SpringDataJpaApp::logAuthor, () -> log.warn("Author by id not found"));
    }

    private static void logBook(final BookProjection book) {
        log.info("Id: {}, Title: {}, isbn: {}, publication date: {}, publisher name: {}", book.getId(), book.getTitle(), book.getIsbn(), book.getPublicationDate(), book.getPublisherName());
    }

    private static void logBookIdIsbn(final BookIdIsbnProjection bookIdIsbnProjection) {
        log.info("Id: {}, isbn: {}", bookIdIsbnProjection.getId(), bookIdIsbnProjection.getIsbn());
    }

    private static void logAuthor(final AuthorProjection authorProjection) {
        log.info("Id: {}, email: {}, first name: {}, last name: {}", authorProjection.getId(), authorProjection.getEmail(), authorProjection.getFirstName(), authorProjection.getLastName());
    }
}
