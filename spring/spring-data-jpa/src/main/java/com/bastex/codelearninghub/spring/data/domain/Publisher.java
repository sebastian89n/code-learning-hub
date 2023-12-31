package com.bastex.codelearninghub.spring.data.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
