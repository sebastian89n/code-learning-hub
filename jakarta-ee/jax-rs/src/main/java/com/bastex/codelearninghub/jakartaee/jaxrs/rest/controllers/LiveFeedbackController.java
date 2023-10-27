package com.bastex.codelearninghub.jakartaee.jaxrs.rest.controllers;

import com.bastex.codelearninghub.jakartaee.jaxrs.services.LiveFeedbackService;
import com.bastex.codelearninghub.jakartaee.jaxrs.web.RequestValidationUtils;
import com.bastex.codelearninghub.jakartaee.jaxrs.web.requests.CreateFeedbackRequest;
import com.bastex.codelearninghub.jakartaee.jaxrs.web.responses.FeedbackResponse;
import com.bastex.codelearninghub.jakartaee.jaxrs.web.responses.FeedbacksListResponse;
import jakarta.inject.Singleton;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
@Singleton
@Path("/feedbacks") // path will apply to all endpoints inside controller
@Produces(MediaType.APPLICATION_JSON) // can be annotated on class for all endpoints or on specific endpoints separately
@Consumes(MediaType.APPLICATION_JSON) // can be annotated on class for all endpoints or on specific endpoints separately
public class LiveFeedbackController {
    private final LiveFeedbackService liveFeedbackService = LiveFeedbackService.newInMemoryInstance();

    @PUT
    // example of specifying produced type on the method. Supports multiple types.
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes(MediaType.APPLICATION_JSON) // example of specifying consumed type on the method
    public Response createFeedback(final CreateFeedbackRequest request) {
        RequestValidationUtils.validateRequest(request);

        final FeedbackResponse feedbackResponse = liveFeedbackService.createFeedback(request);
        return Response.ok(feedbackResponse).build();
    }

    @GET
    public Response getAllFeedbacks(@QueryParam("userId") final String userId) {
        final FeedbacksListResponse feedbacksResponse = new FeedbacksListResponse();
        if (userId == null || userId.isBlank()) {
            feedbacksResponse.setFeedbacks(liveFeedbackService.findAllFeedbacks());
        } else {
            feedbacksResponse.setFeedbacks(liveFeedbackService.findAllFeedbacksByUserId(userId));
        }

        return Response.ok(feedbacksResponse).build();
    }

    @DELETE
    public Response deleteFeedbacks(@QueryParam("userId") final String userId) {
        final boolean deleted = userId != null ? liveFeedbackService.deleteFeedbacksByUserId(userId)
                : liveFeedbackService.deleteAllFeedbacks();

        final Response response;
        if (deleted) {
            response = Response.ok().build();
        } else {
            response = Response.notModified().build();
        }

        return response;
    }

    @GET
    @Path("/{feedbackId}") // produced path will be /feedback/{feedbackId}
    public Response getFeedbackById(@PathParam("feedbackId") final long feedbackId) {
        final Optional<FeedbackResponse> feedbackById = liveFeedbackService.findFeedbackById(feedbackId);
        final Response response;
        if (feedbackById.isPresent()) {
            response = Response.ok(feedbackById.get()).build();
        } else {
            response = Response.notModified().build();
        }

        return response;
    }

    @DELETE
    @Path("/{feedbackId}")
    public Response deleteFeedbackById(@PathParam("feedbackId") final long feedbackId) {
        final boolean deleted = liveFeedbackService.deleteFeedbackById(feedbackId);

        final Response response;
        if (deleted) {
            response = Response.ok().build();
        } else {
            response = Response.status(Response.Status.NOT_FOUND).build();
        }

        return response;
    }
}
