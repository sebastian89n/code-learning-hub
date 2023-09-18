package com.bastex.codelearninghub.spring.context.di.domain;

import lombok.*;

import javax.persistence.*;

/**
 * Sample entity, for Spring Data JPA repository example.
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;
}
