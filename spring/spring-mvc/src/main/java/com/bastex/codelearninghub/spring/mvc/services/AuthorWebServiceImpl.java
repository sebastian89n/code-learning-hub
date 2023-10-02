package com.bastex.codelearninghub.spring.mvc.services;

import com.bastex.codelearninghub.spring.data.domain.Author;
import com.bastex.codelearninghub.spring.data.domain.query.AuthorSort;
import com.bastex.codelearninghub.spring.data.services.AuthorDataService;
import com.bastex.codelearninghub.spring.mvc.dto.request.AuthorSortRequest;
import com.bastex.codelearninghub.spring.mvc.dto.response.AuthorResponse;
import com.bastex.codelearninghub.spring.mvc.transformers.AuthorTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class AuthorWebServiceImpl implements AuthorWebService {
    private final AuthorDataService authorDataService;

    @Override
    public List<AuthorResponse> findAllAuthors(final int page, final int size, final AuthorSortRequest sortApi) {
        final AuthorSort authorSort = AuthorTransformer.INSTANCE.toAuthorSort(sortApi);

        return authorDataService.findAll(page, size, authorSort)
                .stream()
                .map(AuthorTransformer.INSTANCE::toAuthorResponse)
                .toList();
    }

    @Override
    public Optional<AuthorResponse> findAuthorById(final long authorId) {
        return authorDataService.findById(authorId)
                .map(AuthorTransformer.INSTANCE::toAuthorResponse);
    }

    @Override
    public long createNewAuthor(final String email, final String firstName, final String lastName) {
        final Author newAuthor = new Author();
        newAuthor.setEmail(email);
        newAuthor.setFirstName(firstName);
        newAuthor.setLastName(lastName);
        return authorDataService.save(newAuthor);
    }
}
