package com.bastex.codelearninghub.spring.mvc.rest;

import com.bastex.codelearninghub.spring.mvc.dto.request.CreateAuthorRequest;
import com.bastex.codelearninghub.spring.mvc.dto.response.CreateAuthorResponse;
import com.bastex.codelearninghub.spring.mvc.services.AuthorWebService;
import com.bastex.codelearninghub.spring.mvc.utils.ApiValidationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/authors")
@RequiredArgsConstructor
public class AuthorRestController {
    private final AuthorWebService authorWebService;

    @PostMapping
    public CreateAuthorResponse createNewAuthor(@RequestBody final CreateAuthorRequest request) {
        ApiValidationUtils.validateCreateAuthorRequest(request);

        final long authorId = authorWebService.createNewAuthor(request.getEmail(), request.getFirstName(), request.getLastName());
        return new CreateAuthorResponse(authorId);
    }
}
