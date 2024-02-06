package com.bastex.codelearninghub.spring.data.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.LinkedHashSet;
import java.util.Set;

@Setter
@Getter
@ToString(callSuper = true, exclude = {"books"})
@Entity
@Table(name = "publishers")
public class Publisher extends BaseEntity {
    @Column(name = "name", nullable = false, length = 128)
    private String name;

    @Column(name = "email", length = 64)
    private String email;

    @Column(name = "phonenumber", length = 32)
    private String phoneNumber;

    @Embedded
    public Address address;

    @Setter(value = AccessLevel.PACKAGE)
    @OneToMany(mappedBy = "publisher")
    private Set<Book> books = new LinkedHashSet<>();
}
