package com.bastex.codelearninghub.spring.data.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@ToString(callSuper = true, exclude = {"authors"})
public class Book extends BaseEntity {
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "isbn", nullable = false)
    private String isbn;

    @Column(name = "publicationdate", columnDefinition = "DATE", nullable = false)
    private LocalDate publicationDate;

    @Setter(value = AccessLevel.PACKAGE)
    @ManyToMany
    @JoinTable(name = "author_book",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new LinkedHashSet<>();

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;
}
