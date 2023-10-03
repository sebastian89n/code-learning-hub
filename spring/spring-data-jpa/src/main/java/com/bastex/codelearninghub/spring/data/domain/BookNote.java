package com.bastex.codelearninghub.spring.data.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@ToString(exclude = "book")
@Entity
@Table(name = "book_notes")
public class BookNote extends BaseEntity {

    @Column(name = "note")
    @Lob
    private String note;

    @OneToOne(mappedBy = "note")
    private Book book;
}
