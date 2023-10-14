package com.bastex.codelearninghub.jakartaee.jaxrs.rest.exceptionmappers;

import com.bastex.codelearninghub.jakartaee.jaxrs.web.responses.ValidationErrorResponse;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

/**
 * Exception mapper that intercepts any exceptions that extends WebApplicationException
 * If message is provided in the exception it will create a payload response object with details.
 */
@Provider
public class GlobalExceptionMapper implements ExceptionMapper<WebApplicationException> {
    @Override
    public Response toResponse(final WebApplicationException e) {
        if (e.getResponse() != null && e.getMessage() != null && !e.getMessage().isBlank()) {
            return Response.status(e.getResponse().getStatus())
                    .entity(new ValidationErrorResponse(e.getMessage()))
                    .build();
        }

        return e.getResponse();
    }
}
