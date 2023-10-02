package com.bastex.codelearninghub.spring.mvc.controllers;

import com.bastex.codelearninghub.spring.mvc.dto.request.BookSortRequest;
import com.bastex.codelearninghub.spring.mvc.dto.response.BookResponse;
import com.bastex.codelearninghub.spring.mvc.services.BookWebService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

/**
 * Example of MVC controller. @RequestMapping maps endpoint. It returns ModelAndView.
 * By the default Spring Boot looks uses Thymeleaf template engine and looks for template in resources/templates.
 * You can pass model data to the view in the controllers. Controller will redirect to the proper page.
 */
@Controller
@RequestMapping("books")
@RequiredArgsConstructor
public class BookMvcController {
    private final BookWebService bookWebService;

    @RequestMapping
    public ModelAndView booksList(@RequestParam(name = "page", defaultValue = "0") final int page,
                                  @RequestParam(name = "size", defaultValue = "100") final int size,
                                  @RequestParam(name = "sort", defaultValue = "idAscending") final BookSortRequest sort) {
        final List<BookResponse> books = bookWebService.findAllBooks(page, size, sort);

        final ModelAndView modelAndView = new ModelAndView("books/booksList");
        modelAndView.addObject("books", books);
        return modelAndView;
    }

    @RequestMapping({"/{bookId}"})
    public ModelAndView booksById(@PathVariable("bookId") final long bookId) {
        final ModelAndView modelAndView = new ModelAndView();

        final Optional<BookResponse> bookResponse = bookWebService.findBookById(bookId);
        if (bookResponse.isPresent()) {
            modelAndView.setViewName("books/singleBook");
            modelAndView.addObject("book", bookResponse.get());
        } else {
            modelAndView.setViewName("notFound");
        }

        return modelAndView;
    }
}
