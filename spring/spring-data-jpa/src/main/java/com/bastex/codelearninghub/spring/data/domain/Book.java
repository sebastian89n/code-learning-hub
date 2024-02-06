package com.bastex.codelearninghub.spring.data.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "books")
@Setter
@Getter
@ToString(callSuper = true, exclude = {"authors", "publisher"})
public class Book extends BaseEntity {
    @Column(name = "active", nullable = false, columnDefinition = "CHAR(1)", length = 1)
    @Convert(converter = org.hibernate.type.TrueFalseConverter.class)
    private boolean active = true;

    @Column(name = "title", nullable = false, length = 128)
    private String title;

    @Column(name = "isbn", nullable = false, length = 128)
    private String isbn;

    @Column(name = "type", nullable = false, length = 32)
    @Enumerated(EnumType.STRING)
    private BookType type;

    @Column(name = "publicationdate", columnDefinition = "DATE", nullable = false)
    private LocalDate publicationDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "note_id")
    private BookNote note;

    @ManyToOne
    @JoinColumn(name = "publisher_id", referencedColumnName = "oid") // optionally can specify referenced column name
    private Publisher publisher;

    @Setter(value = AccessLevel.PACKAGE)
    @ManyToMany
    @JoinTable(name = "author_book",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new LinkedHashSet<>();
}
