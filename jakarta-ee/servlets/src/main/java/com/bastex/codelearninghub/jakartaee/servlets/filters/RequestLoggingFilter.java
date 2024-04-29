package com.bastex.codelearninghub.jakartaee.servlets.filters;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class RequestLoggingFilter implements Filter {
    @Override
    public void init(final FilterConfig filterConfig) {
        log.info("Starting {} filter", RequestLoggingFilter.class.getSimpleName());
    }

    @Override
    public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse, final FilterChain filterChain) throws ServletException, IOException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        log.info("From {}:{} {} {}", request.getRemoteAddr(),
                request.getRemotePort(),
                request.getMethod(),
                request.getRequestURI());

        // forwards to next Filter in chain
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        log.info("Destroying {} filter", RequestLoggingFilter.class.getSimpleName());
    }
}
