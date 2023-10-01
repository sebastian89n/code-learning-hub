package com.bastex.codelearninghub.spring.mvc.controllers;

import com.bastex.codelearninghub.spring.mvc.dto.request.AuthorSortRequest;
import com.bastex.codelearninghub.spring.mvc.dto.response.AuthorResponse;
import com.bastex.codelearninghub.spring.mvc.services.AuthorWebService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

/**
 * Same as BookController except it uses a different approach. Methods return String with view name.
 * Model object is injected by Spring in the method argument, and you can pass model data there.
 * It behaves the same as BookController, just another way to do things.
 */
@Controller
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorWebService authorWebService;

    @RequestMapping
    public String authorsList(@RequestParam(name = "page", defaultValue = "0") final int page,
                              @RequestParam(name = "size", defaultValue = "100") final int size,
                              @RequestParam(name = "sort", defaultValue = "idAscending") final AuthorSortRequest sort,
                              final Model model) {
        final List<AuthorResponse> authors = authorWebService.findAllAuthors(page, size, sort);

        model.addAttribute("authors", authors);
        return "authors/authorsList";
    }

    @RequestMapping({"/{authorId}"})
    public String authorById(@PathVariable("authorId") final long authorId, final Model model) {
        final Optional<AuthorResponse> authorResponse = authorWebService.findAuthorById(authorId);
        if (authorResponse.isPresent()) {
            model.addAttribute("author", authorResponse.get());
            return "authors/singleAuthor";
        } else {
            return "notFound";
        }
    }
}
