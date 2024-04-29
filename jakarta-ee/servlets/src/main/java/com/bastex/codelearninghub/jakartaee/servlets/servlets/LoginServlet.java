package com.bastex.codelearninghub.jakartaee.servlets.servlets;

import com.bastex.codelearninghub.jakartaee.servlets.dto.User;
import com.bastex.codelearninghub.jakartaee.servlets.services.AuthenticationService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private AuthenticationService authenticationService;

    @Override
    public void init() {
        authenticationService = AuthenticationService.newInMemoryInstance("users.properties");
    }

    @Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute(User.USER_SESSION_KEY);

        final String username = request.getParameter("username");
        final String password = request.getParameter("password");

        if (isAuthParamsProvided(username, password)) {
            final boolean authenticated = authenticationService.authenticateUser(username, password);
            if (authenticated) {
                request.getSession().setAttribute(User.USER_SESSION_KEY, username);
                response.sendRedirect(request.getContextPath() + "/servlets-info.html");
            } else {
                response.getWriter().println("Unable to authenticate user");
            }
        } else {
            response.getWriter().println("Unable to authenticate user. Please provider valid username and password");
        }

    }

    private static boolean isAuthParamsProvided(final String username, final String password) {
        return username != null
                && !username.isBlank()
                && password != null
                && !password.isBlank();
    }
}
