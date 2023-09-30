package com.bastex.codelearninghub.spring.data.repositories;

import com.bastex.codelearninghub.spring.data.domain.Author;
import com.bastex.codelearninghub.spring.data.domain.dto.AuthorDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    /**
     * Spring Data will automatically provide implementation for the interface. We just need to map properties to getters provided in the interface
     */
    @Query("SELECT a.id AS id, " +
            "a.createdTimestamp AS createdTimestamp, " +
            "a.lastUpdatedTimestamp AS lastUpdatedTimestamp, " +
            "a.email AS email, " +
            "a.firstName AS firstName, " +
            "a.lastName AS lastName " +
            "FROM Author a")
    Page<AuthorDTO> findAllAuthors(Pageable page);
}
