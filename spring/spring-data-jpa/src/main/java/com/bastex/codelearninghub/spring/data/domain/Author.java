package com.bastex.codelearninghub.spring.data.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@ToString(callSuper = true, exclude = {"books"})
public class Author extends BaseEntity {
    @Column(name = "email")
    public String email;

    @Column(name = "firstname", nullable = false)
    public String firstName;

    @Column(name = "lastname", nullable = false)
    public String lastName;

    @Setter(value = AccessLevel.PACKAGE)
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new LinkedHashSet<>();
}
