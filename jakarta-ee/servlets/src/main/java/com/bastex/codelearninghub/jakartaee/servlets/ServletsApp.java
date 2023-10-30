package com.bastex.codelearninghub.jakartaee.servlets;

import lombok.SneakyThrows;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class ServletsApp {
    @SneakyThrows
    public static void main(final String[] args) {
        final Server server = new Server(8080);

        final WebAppContext webAppContext = new WebAppContext();
        webAppContext.setContextPath("/servlets-app");
        webAppContext.setResourceBase("src/main/webapp");
        webAppContext.setDescriptor("src/main/webapp/WEB-INF/web.xml");
        webAppContext.setClassLoader(ServletsApp.class.getClassLoader());

        server.setHandler(webAppContext);

        server.start();
        server.join();
    }
}
