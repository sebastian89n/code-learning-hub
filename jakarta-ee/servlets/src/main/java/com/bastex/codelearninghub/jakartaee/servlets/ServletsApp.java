package com.bastex.codelearninghub.jakartaee.servlets;

import com.bastex.codelearninghub.jakartaee.servlets.filters.PreAuthenticationFilter;
import com.bastex.codelearninghub.jakartaee.servlets.filters.RequestLoggingFilter;
import com.bastex.codelearninghub.jakartaee.servlets.servlets.LoginServlet;
import jakarta.servlet.DispatcherType;
import lombok.SneakyThrows;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.util.EnumSet;

public class ServletsApp {
    @SneakyThrows
    public static void main(final String[] args) {
        final Server server = new Server(8080);

        // Create a ServletContextHandler
        final ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/servlets-app");

        // Register filters programmatically
        context.addFilter(new FilterHolder(new RequestLoggingFilter()), "/*", EnumSet.of(DispatcherType.REQUEST));
        context.addFilter(new FilterHolder(new PreAuthenticationFilter()), "/*", EnumSet.of(DispatcherType.REQUEST));

        // Register the DefaultServlet to serve static resources
        final ServletHolder defaultServletHolder = new ServletHolder("default", DefaultServlet.class);
        defaultServletHolder.setInitParameter("resourceBase", "src/main/webapp/static");
        defaultServletHolder.setInitParameter("dirAllowed", "false");
        context.addServlet(defaultServletHolder, "/*");

        // Register servlet programmatically
        context.addServlet(new ServletHolder(new LoginServlet()), "/login");

        // Set up the handlers
        final HandlerList handlerList = new HandlerList();
        handlerList.addHandler(context);

        server.setHandler(handlerList);

        server.start();
        server.join();
    }
}
