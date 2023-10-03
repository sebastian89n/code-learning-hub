package com.bastex.codelearninghub.spring.data.repositories;

import com.bastex.codelearninghub.spring.data.domain.Book;
import com.bastex.codelearninghub.spring.data.domain.projections.BookIdIsbnProjection;
import com.bastex.codelearninghub.spring.data.domain.projections.BookNoteProjection;
import com.bastex.codelearninghub.spring.data.domain.projections.BookProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Repository annotation is optional but causes Spring to do exception translation.
 * It will catch all JDBC/JPA/Hibernate/ORM impl exceptions and re-throw DataAccessException.
 * <p>
 * Extends BookRepositoryCustom that contains customized query implementation with optional parameters.
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long>, BookRepositoryCustom {
    /**
     * Update/Delete queries must be annotated with @Modifying, otherwise an InvalidDataAccessApiUsageException will be thrown.
     */
    @Query("UPDATE Book b SET b.publicationDate = :publicationDate WHERE b.id IN (:bookIds)")
    @Modifying
    int updatePublicationDateByBookIds(@Param("publicationDate") LocalDate newPublicationDate, @Param("bookIds") Set<Long> bookIds);

    @Query("SELECT b.id AS id, " +
            "b.createdTimestamp AS createdTimestamp, " +
            "b.lastUpdatedTimestamp AS lastUpdatedTimestamp, " +
            "b.title AS title, " +
            "b.isbn AS isbn, " +
            "b.publicationDate AS publicationDate, " +
            "b.publisher.name AS publisherName " +
            "FROM Book b WHERE b.id = :bookId")
    Optional<BookProjection> findBookById(@Param("bookId") long bookId);

    @Query("SELECT b.id AS id, " +
            "b.createdTimestamp AS createdTimestamp, " +
            "b.lastUpdatedTimestamp AS lastUpdatedTimestamp, " +
            "b.title AS title, " +
            "b.isbn AS isbn, " +
            "b.publicationDate AS publicationDate, " +
            "b.publisher.name AS publisherName " +
            "FROM Book b")
    Page<BookProjection> findAllBooks(Pageable page);

    @Query("SELECT b.id AS id, " +
            "b.createdTimestamp AS createdTimestamp, " +
            "b.lastUpdatedTimestamp AS lastUpdatedTimestamp, " +
            "b.title AS title, " +
            "b.isbn AS isbn, " +
            "b.publicationDate AS publicationDate, " +
            "b.publisher.name AS publisherName " +
            "FROM Book b " +
            "WHERE b.title LIKE %:title%")
    Page<BookProjection> findAllBooksByTitleContains(@Param("title") String title, Pageable page);

    @Query("SELECT b.id AS id, " +
            "b.createdTimestamp AS createdTimestamp, " +
            "b.lastUpdatedTimestamp AS lastUpdatedTimestamp, " +
            "b.title AS title, " +
            "b.isbn AS isbn, " +
            "b.publicationDate AS publicationDate, " +
            "b.publisher.name AS publisherName " +
            "FROM Book b " +
            "WHERE b.publisher.name = :publisherName")
    Page<BookProjection> findAllBooksByPublisherName(@Param("publisherName") String publisherName, Pageable page);

    /**
     * Example with JOIN
     */
    @Query("SELECT b.id AS id, " +
            "b.createdTimestamp AS createdTimestamp, " +
            "b.lastUpdatedTimestamp AS lastUpdatedTimestamp, " +
            "b.title AS title, " +
            "b.isbn AS isbn, " +
            "b.publicationDate AS publicationDate, " +
            "b.publisher.name AS publisherName " +
            "FROM Book b JOIN b.authors a WHERE a.firstName = :firstName AND a.lastName = :lastName ")
    Page<BookProjection> findAllBooksByAuthor(@Param("firstName") String firstName, @Param("lastName") String lastName, Pageable page);


    @Query("SELECT b.id AS id, " +
            "b.createdTimestamp AS createdTimestamp, " +
            "b.lastUpdatedTimestamp AS lastUpdatedTimestamp, " +
            "n.note AS note " +
            "FROM Book b LEFT JOIN b.note n WHERE b.id = :bookId")
    Optional<BookNoteProjection> findBookNoteById(@Param("bookId") long bookId);

    /**
     * Below examples of Spring Data methods using naming convention.
     */
    Optional<BookIdIsbnProjection> findBookIdIsbnByTitle(String title);

    /**
     * Like requires wildcard % provided in the String
     */
    Page<BookIdIsbnProjection> findAllBookIdIsbnByTitleLike(String title, Pageable page);

    List<BookIdIsbnProjection> findAllBookIdIsbnByTitleContainsAndPublicationDateGreaterThan(String title, LocalDate publicationDate);
}
