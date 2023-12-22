package com.bastex.codelearninghub.java.libs.swagger;

import com.bastex.codelearninghub.java.libs.swagger.rest.RestApplication;
import lombok.extern.slf4j.Slf4j;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

@Slf4j
public class SwaggerApp {
    public static void main(final String[] args) {
        try {
            final ResourceConfig resourceConfig = ResourceConfig.forApplication(new RestApplication());
            resourceConfig.packages("com.bastex.codelearninghub.java.libs.swagger.rest");
            resourceConfig.register(new JacksonFeature());

            final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(
                    URI.create("http://localhost:8080/"), resourceConfig);
            addShutdownHook(server);

            log.info("Application started.");
            Thread.currentThread().join();
        } catch (final InterruptedException e) {
            log.error("Thread interrupted", e);
        }
    }

    private static void addShutdownHook(final HttpServer server) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                log.info("Shutting down the application...");
                server.shutdownNow();
                log.info("Server shut down successfully.");
            } catch (final Exception e) {
                log.error("Unable to stop server.", e);
            }
        }));
    }
}
