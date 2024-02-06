package com.bastex.codelearninghub.spring.data.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.LinkedHashSet;
import java.util.Set;

@Setter
@Getter
@ToString(callSuper = true, exclude = {"books"})
@Entity
@Table(name = "authors")
public class Author extends BaseEntity {
    @Column(name = "firstname", nullable = false, length = 128)
    public String firstName;

    @Column(name = "lastname", nullable = false, length = 128)
    public String lastName;

    @Column(name = "email", length = 64)
    public String email;

    @Setter(value = AccessLevel.PACKAGE)
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new LinkedHashSet<>();
}
