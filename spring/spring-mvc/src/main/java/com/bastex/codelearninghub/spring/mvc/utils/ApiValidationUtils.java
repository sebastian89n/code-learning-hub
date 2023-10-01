package com.bastex.codelearninghub.spring.mvc.utils;

import com.bastex.codelearninghub.spring.mvc.dto.request.CreateAuthorRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ApiValidationUtils {
    public static void validateCreateAuthorRequest(final CreateAuthorRequest request) {
        final boolean requestInvalid = request == null
                || request.getEmail() == null || request.getEmail().isBlank()
                || request.getFirstName() == null || request.getFirstName().isBlank()
                || request.getLastName() == null || request.getLastName().isBlank();

        if (requestInvalid) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "All required fields must be specified");
        }
    }
}
