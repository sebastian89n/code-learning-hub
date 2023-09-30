package com.bastex.codelearninghub.spring.data.repositories;

import com.bastex.codelearninghub.spring.data.domain.Book;
import com.bastex.codelearninghub.spring.data.domain.dto.BookDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repository annotation is optional but causes Spring to do exception translation.
 * It will catch all JDBC/JPA/Hibernate/ORM impl exceptions and re-throw DataAccessException
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b.id AS id, " +
            "b.createdTimestamp AS createdTimestamp, " +
            "b.lastUpdatedTimestamp AS lastUpdatedTimestamp, " +
            "b.title AS title, " +
            "b.isbn AS isbn, " +
            "b.publicationDate AS publicationDate, " +
            "b.publisher.name AS publisherName " +
            "FROM Book b")
    Page<BookDTO> findAllBooks(Pageable page);
}
