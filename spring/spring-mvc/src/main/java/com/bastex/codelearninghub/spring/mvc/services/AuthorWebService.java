package com.bastex.codelearninghub.spring.mvc.services;

import com.bastex.codelearninghub.spring.mvc.dto.request.AuthorSortRequest;
import com.bastex.codelearninghub.spring.mvc.dto.response.AuthorResponse;

import java.util.List;
import java.util.Optional;

public interface AuthorWebService {
    List<AuthorResponse> findAllAuthors(int page, int size, AuthorSortRequest sort);

    Optional<AuthorResponse> findAuthorById(long authorId);

    long createNewAuthor(String email, String firstName, String lastName);
}
