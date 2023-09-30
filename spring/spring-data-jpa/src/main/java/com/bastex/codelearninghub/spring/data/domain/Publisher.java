package com.bastex.codelearninghub.spring.data.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@ToString(callSuper = true, exclude = {"books"})
public class Publisher extends BaseEntity {
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "addresslocal")
    private String addressLocal;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zip")
    private String zip;

    @Setter(value = AccessLevel.PACKAGE)
    @OneToMany(mappedBy = "publisher")
    private Set<Book> books = new LinkedHashSet<>();
}
