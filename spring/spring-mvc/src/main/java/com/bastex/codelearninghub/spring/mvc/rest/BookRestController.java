package com.bastex.codelearninghub.spring.mvc.rest;

import com.bastex.codelearninghub.spring.mvc.dto.request.BookSortRequest;
import com.bastex.codelearninghub.spring.mvc.dto.response.BookResponse;
import com.bastex.codelearninghub.spring.mvc.dto.response.GetBooksResponse;
import com.bastex.codelearninghub.spring.mvc.dto.response.GetSingleBookResponse;
import com.bastex.codelearninghub.spring.mvc.services.BookWebService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

/**
 * RestController annotations combines @Controller and @ResponseBody annotations.
 * It defines regular REST controller that will return data instead of redirecting to view.
 */
@RestController
@RequestMapping("/rest/books")
@RequiredArgsConstructor
public class BookRestController {
    private final BookWebService bookWebService;

    /**
     * Equivalent to @RequestMapping(produces = "application/json", method = RequestMethod.GET)
     */
    @GetMapping
    public GetBooksResponse getBooks(@RequestParam(name = "page", defaultValue = "0") final int page,
                                     @RequestParam(name = "size", defaultValue = "100") final int size,
                                     @RequestParam(name = "sort", defaultValue = "idAscending") final BookSortRequest sort) {
        final List<BookResponse> books = bookWebService.findAllBooks(page, size, sort);
        return new GetBooksResponse(books);
    }

    /**
     * produces is optional here, application/json by default in Spring Boot(unless changed on purpose)
     */
    @GetMapping(value = "/{bookId}", produces = "application/json")
    public GetSingleBookResponse getBookById(@PathVariable("bookId") final long bookId) {
        final Optional<BookResponse> bookResponse = bookWebService.findBookById(bookId);
        return bookResponse.map(GetSingleBookResponse::new)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
