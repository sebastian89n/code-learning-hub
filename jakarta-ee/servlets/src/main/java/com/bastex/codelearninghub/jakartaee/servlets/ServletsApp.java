package com.bastex.codelearninghub.jakartaee.servlets;

import com.bastex.codelearninghub.jakartaee.servlets.filters.PreAuthenticationFilter;
import com.bastex.codelearninghub.jakartaee.servlets.filters.RequestLoggingFilter;
import com.bastex.codelearninghub.jakartaee.servlets.servlets.AuthenticationServlet;
import lombok.SneakyThrows;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class ServletsApp {
    @SneakyThrows
    public static void main(final String[] args) {
        final Server server = new Server(8080);

        // Create a ContextHandlerCollection to manage multiple handlers
        final ContextHandlerCollection handlers = new ContextHandlerCollection();

        // Create a ServletContextHandler for your web application
        final ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);

        // Register filters programmatically
        context.addFilter(RequestLoggingFilter.class, "/*", null);
        context.addFilter(PreAuthenticationFilter.class, "/*", null);

        // Register servlet programmatically
        context.addServlet(new ServletHolder(new AuthenticationServlet()), "/auth");

        // Add the ServletContextHandler to the ContextHandlerCollection
        handlers.addHandler(context);

        // Create a ResourceHandler for serving static content
        final ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setDirectoriesListed(false);
        resourceHandler.setWelcomeFiles(new String[]{"login.html"});
        resourceHandler.setResourceBase("src/main/resources/static"); // Set the static resource directory

        // Create a ContextHandler to handle static resources
        final ContextHandler resourceContext = new ContextHandler("/static");
        resourceContext.setHandler(resourceHandler);

        // Add the ContextHandler for static resources to the ContextHandlerCollection
        handlers.addHandler(resourceContext);

        server.setHandler(handlers);

        server.start();
        server.join();
    }
}
