package com.bastex.codelearninghub.spring.data.repositories;

import com.bastex.codelearninghub.spring.data.domain.projections.BookProjection;
import com.bastex.codelearninghub.spring.data.domain.query.BookSearchQuery;

import java.util.List;

public interface BookRepositoryCustom {
    List<BookProjection> searchBooks(BookSearchQuery bookSearchQuery);
}
