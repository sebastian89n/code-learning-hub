package com.bastex.codelearninghub.spring.data.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Getter
@Setter
@ToString(exclude = "book")
@Entity
@Table(name = "book_notes")
public class BookNote extends BaseEntity {

    @Column(name = "note")
    @Lob // @Lob with String type will generate clob
    private String note;

    @OneToOne(mappedBy = "note")
    private Book book;
}
