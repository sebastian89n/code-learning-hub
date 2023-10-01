package com.bastex.codelearninghub.spring.mvc.services;

import com.bastex.codelearninghub.spring.data.domain.query.BookSort;
import com.bastex.codelearninghub.spring.data.services.BookService;
import com.bastex.codelearninghub.spring.mvc.dto.request.BookSortRequest;
import com.bastex.codelearninghub.spring.mvc.dto.response.BookResponse;
import com.bastex.codelearninghub.spring.mvc.transformers.BookTransformer;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class BookWebServiceImpl implements BookWebService {
    private final BookService bookService;

    @Override
    public List<BookResponse> findAllBooks(final int page, final int size, @NonNull final BookSortRequest sortApi) {
        final BookSort bookSort = BookTransformer.INSTANCE.toBookSort(sortApi);

        return bookService.findAll(page, size, bookSort)
                .stream()
                .map(BookTransformer.INSTANCE::toBookResponse)
                .toList();
    }

    @Override
    public Optional<BookResponse> findBookById(final long bookId) {
        return bookService.findById(bookId)
                .map(BookTransformer.INSTANCE::toBookResponse);
    }
}
