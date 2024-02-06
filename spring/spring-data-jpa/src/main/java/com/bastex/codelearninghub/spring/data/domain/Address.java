package com.bastex.codelearninghub.spring.data.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/**
 * Can be embedded as part of another entity.
 */
@Embeddable
@Setter
@Getter
@ToString
public class Address {
    @Column(name = "addresslocal", length = 64)
    private String addressLocal;

    @Column(name = "city", length = 64)
    private String city;

    @Column(name = "state", length = 64)
    private String state;

    @Column(name = "zip", length = 32)
    private String zip;

    @Column(name = "country", length = 64)
    private String country;
}
