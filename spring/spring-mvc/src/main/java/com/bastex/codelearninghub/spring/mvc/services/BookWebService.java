package com.bastex.codelearninghub.spring.mvc.services;

import com.bastex.codelearninghub.spring.mvc.dto.request.BookSortRequest;
import com.bastex.codelearninghub.spring.mvc.dto.response.BookResponse;

import java.util.List;
import java.util.Optional;

public interface BookWebService {
    List<BookResponse> findAllBooks(int page, int size, BookSortRequest sort);

    Optional<BookResponse> findBookById(long bookId);
}
