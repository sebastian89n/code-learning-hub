package com.bastex.codelearninghub.spring5.boot.domain;

import jakarta.persistence.*;
import lombok.*;

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
