package com.bastex.codelearninghub.spring.data.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Can be embedded as part of another entity.
 */
@Embeddable
@Setter
@Getter
@ToString
public class Address {
    @Column(name = "addresslocal")
    private String addressLocal;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zip")
    private String zip;

    @Column(name = "country")
    private String country;
}
