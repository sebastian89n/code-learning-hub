package com.bastex.codelearninghub.spring.data.services;


import com.bastex.codelearninghub.spring.data.domain.Book;
import com.bastex.codelearninghub.spring.data.domain.dto.BookDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    void save(Book book);

    Page<BookDTO> findAll(Pageable page);

    long count();
}
