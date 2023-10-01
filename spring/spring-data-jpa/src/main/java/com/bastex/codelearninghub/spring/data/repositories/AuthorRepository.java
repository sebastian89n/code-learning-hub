package com.bastex.codelearninghub.spring.data.repositories;

import com.bastex.codelearninghub.spring.data.domain.Author;
import com.bastex.codelearninghub.spring.data.domain.projections.AuthorProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    /**
     * Retrieving projections: Spring Data will automatically provide implementation for the interface.
     * We just need to map properties to getters provided in the interface
     */
    Optional<AuthorProjection> findAuthorById(long id);

    Page<AuthorProjection> findAllAuthorsBy(Pageable page);

}
