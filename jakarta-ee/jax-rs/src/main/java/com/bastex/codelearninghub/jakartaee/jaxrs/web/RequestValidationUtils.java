package com.bastex.codelearninghub.jakartaee.jaxrs.web;

import com.bastex.codelearninghub.jakartaee.jaxrs.web.requests.CreateFeedbackRequest;
import jakarta.ws.rs.BadRequestException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RequestValidationUtils {
    public static void validateRequest(final CreateFeedbackRequest createFeedbackRequest) {
        if (createFeedbackRequest == null) {
            throw new BadRequestException("Feedback request must be provided");
        }

        final boolean isValidRequest = createFeedbackRequest.getUserId() == null
                || createFeedbackRequest.getUserId().isBlank()
                || createFeedbackRequest.getText() == null
                || createFeedbackRequest.getText().isBlank();
        if (isValidRequest) {
            throw new BadRequestException("All required fields in Feedback request must be provided");
        }
    }
}
