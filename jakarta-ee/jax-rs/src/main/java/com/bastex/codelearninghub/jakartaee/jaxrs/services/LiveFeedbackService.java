package com.bastex.codelearninghub.jakartaee.jaxrs.services;

import com.bastex.codelearninghub.jakartaee.jaxrs.web.requests.CreateFeedbackRequest;
import com.bastex.codelearninghub.jakartaee.jaxrs.web.responses.FeedbackResponse;

import java.util.List;
import java.util.Optional;

public interface LiveFeedbackService {
    static LiveFeedbackService newInMemoryInstance() {
        return new LiveFeedbackInMemoryService();
    }

    FeedbackResponse createFeedback(CreateFeedbackRequest feedback);

    boolean deleteFeedbackById(long feedbackId);

    boolean deleteFeedbacksByUserId(String userId);

    boolean deleteAllFeedbacks();

    Optional<FeedbackResponse> findFeedbackById(long feedbackId);

    List<FeedbackResponse> findAllFeedbacksByUserId(String userId);

    List<FeedbackResponse> findAllFeedbacks();
}
