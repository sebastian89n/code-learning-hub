package com.bastex.codelearninghub.jakartaee.jaxrs.services;

import com.bastex.codelearninghub.jakartaee.jaxrs.domain.Feedback;
import com.bastex.codelearninghub.jakartaee.jaxrs.transformers.FeedbackTransformer;
import com.bastex.codelearninghub.jakartaee.jaxrs.web.requests.FeedbackRequest;
import com.bastex.codelearninghub.jakartaee.jaxrs.web.responses.FeedbackResponse;
import jakarta.inject.Singleton;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Singleton
class LiveFeedbackInMemoryService implements LiveFeedbackService {
    private final Map<Long, Feedback> feedbacksById = new LinkedHashMap<>();

    @Override
    public FeedbackResponse addFeedback(final FeedbackRequest feedbackRequest) {
        final Feedback feedback = FeedbackTransformer.INSTANCE.toFeedback(feedbackRequest);
        feedback.setId(getNextId());
        feedbacksById.put(feedback.getId(), feedback);
        return FeedbackTransformer.INSTANCE.toFeedbackResponse(feedback);
    }

    @Override
    public boolean deleteFeedbackById(final long feedbackId) {
        final Feedback remove = feedbacksById.remove(feedbackId);
        return remove != null;
    }

    @Override
    public boolean deleteFeedbacksByUserId(final String userId) {
        return feedbacksById.values()
                .removeIf(feedback -> feedback.getUserId().equals(userId));
    }

    @Override
    public boolean deleteAllFeedbacks() {
        feedbacksById.clear();
        return true;
    }

    @Override
    public Optional<FeedbackResponse> findFeedbackById(final long feedbackId) {
        final Feedback feedback = feedbacksById.get(feedbackId);
        return Optional.ofNullable(feedback)
                .map(FeedbackTransformer.INSTANCE::toFeedbackResponse);
    }

    @Override
    public List<FeedbackResponse> findAllFeedbacksByUserId(final String userId) {
        return feedbacksById.values().stream()
                .filter(feedback -> feedback.getUserId().equals(userId))
                .sorted(Comparator.comparing(Feedback::getCreated).reversed())
                .map(FeedbackTransformer.INSTANCE::toFeedbackResponse)
                .toList();
    }

    @Override
    public List<FeedbackResponse> findAllFeedbacks() {
        return feedbacksById.values().stream()
                .sorted(Comparator.comparing(Feedback::getCreated).reversed())
                .map(FeedbackTransformer.INSTANCE::toFeedbackResponse)
                .toList();
    }

    private Long getNextId() {
        return feedbacksById.isEmpty() ? 1 : Collections.max(feedbacksById.keySet()) + 1;
    }
}
