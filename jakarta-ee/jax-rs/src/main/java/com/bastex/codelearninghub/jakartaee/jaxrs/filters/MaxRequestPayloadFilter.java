package com.bastex.codelearninghub.jakartaee.jaxrs.filters;

import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;

/**
 * Example of Request Filter
 */
@Slf4j
@Provider
public class MaxRequestPayloadFilter implements ContainerRequestFilter {
    @Override
    public void filter(final ContainerRequestContext requestContext) {
        if (requestContext.getMethod().equalsIgnoreCase("PUT")) {
            final String contentLengthHeaderValue = requestContext.getHeaderString("content-length");
            if (contentLengthHeaderValue == null) {
                throw new BadRequestException("Content-length not found in the request");
            }

            final long contentLength = Long.parseLong(contentLengthHeaderValue);
            if (contentLength > 500) {
                throw new BadRequestException("Content payload is too big");
            }
        }
    }
}
