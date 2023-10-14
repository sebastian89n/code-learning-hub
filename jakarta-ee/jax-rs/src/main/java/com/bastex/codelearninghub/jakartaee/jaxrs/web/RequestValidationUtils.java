package com.bastex.codelearninghub.jakartaee.jaxrs.web;

import com.bastex.codelearninghub.jakartaee.jaxrs.web.requests.FeedbackRequest;
import jakarta.ws.rs.BadRequestException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RequestValidationUtils {
    public static void validateRequest(final FeedbackRequest feedbackRequest) {
        if (feedbackRequest == null) {
            throw new BadRequestException("Feedback request must be provided");
        }

        final boolean isValidRequest = feedbackRequest.getUserId() == null
                || feedbackRequest.getUserId().isBlank()
                || feedbackRequest.getText() == null
                || feedbackRequest.getText().isBlank();
        if (isValidRequest) {
            throw new BadRequestException("All required fields in Feedback request must be provided");
        }
    }
}
