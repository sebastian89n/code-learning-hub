package com.bastex.codelearninghub.jakartaee.jaxrs.rest.controllers;

import com.bastex.codelearninghub.jakartaee.jaxrs.services.LiveFeedbackService;
import com.bastex.codelearninghub.jakartaee.jaxrs.web.RequestValidationUtils;
import com.bastex.codelearninghub.jakartaee.jaxrs.web.requests.FeedbackRequest;
import com.bastex.codelearninghub.jakartaee.jaxrs.web.responses.FeedbackResponse;
import com.bastex.codelearninghub.jakartaee.jaxrs.web.responses.FeedbacksListResponse;
import jakarta.inject.Singleton;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
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
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addFeedback(final FeedbackRequest request) {
        RequestValidationUtils.validateRequest(request);

        final FeedbackResponse feedbackResponse = liveFeedbackService.addFeedback(request);
        return Response.ok(feedbackResponse).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllFeedbacks(@QueryParam("userId") final String userId) {
        final FeedbacksListResponse feedbacksResponse = new FeedbacksListResponse();
        if (userId == null) {
            feedbacksResponse.setFeedbacks(liveFeedbackService.findAllFeedbacks());
        } else {
            feedbacksResponse.setFeedbacks(liveFeedbackService.findAllFeedbacksByUserId(userId));
        }

        return Response.ok(feedbacksResponse).build();
    }

    /**
     * Injecting HttpServletRequest via @Context to get query param instead of using @QueryParam("userId")
     */
    @DELETE
    public Response deleteFeedbacks(@Context final HttpServletRequest request) {
        final String userId = request.getParameter("userId");
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
