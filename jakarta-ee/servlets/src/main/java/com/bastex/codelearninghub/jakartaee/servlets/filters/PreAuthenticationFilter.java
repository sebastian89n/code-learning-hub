package com.bastex.codelearninghub.jakartaee.servlets.filters;

import com.bastex.codelearninghub.jakartaee.servlets.dto.User;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class PreAuthenticationFilter implements Filter {

    @Override
    public void init(final FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse, final FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletRequest;

        if (isAuthenticated(request) || isAccessingStaticResource(request)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            response.sendRedirect("/login.html");
        }
    }

    @Override
    public void destroy() {
    }

    private boolean isAuthenticated(final HttpServletRequest request) {
        return request.getSession(false) != null
                && request.getSession().getAttribute(User.USER_SESSION_KEY) != null;
    }

    private static boolean isAccessingStaticResource(final HttpServletRequest request) {
        final String servletPath = request.getServletPath();
        return servletPath.startsWith("/static/");
    }
}
