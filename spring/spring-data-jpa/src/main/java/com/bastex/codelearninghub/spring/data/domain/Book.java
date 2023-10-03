package com.bastex.codelearninghub.spring.data.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "books")
@Setter
@Getter
@ToString(callSuper = true, exclude = {"authors", "publisher"})
public class Book extends BaseEntity {
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "isbn", nullable = false)
    private String isbn;

    @Column(name = "publicationdate", columnDefinition = "DATE", nullable = false)
    private LocalDate publicationDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "note_id")
    private BookNote note;

    @Setter(value = AccessLevel.PACKAGE)
    @ManyToMany
    @JoinTable(name = "author_book",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "oid"),
            inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "oid"))
    private Set<Author> authors = new LinkedHashSet<>();

    @ManyToOne
    @JoinColumn(name = "publisher_id", referencedColumnName = "oid")
    private Publisher publisher;
}
