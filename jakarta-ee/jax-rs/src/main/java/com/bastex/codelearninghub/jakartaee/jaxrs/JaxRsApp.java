package com.bastex.codelearninghub.jakartaee.jaxrs;

import com.bastex.codelearninghub.jakartaee.jaxrs.rest.RestApplication;
import lombok.extern.slf4j.Slf4j;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

@Slf4j
public class JaxRsApp {
    public static void main(final String[] args) {
        try {
//            final RestResourceConfig resourceConfig = new RestResourceConfig();
            final ResourceConfig resourceConfig = ResourceConfig.forApplication(new RestApplication());
            resourceConfig.packages("com.bastex.codelearninghub.jakartaee.jaxrs.rest",
                    "com.bastex.codelearninghub.jakartaee.jaxrs.filters");
            resourceConfig.register(new JacksonFeature());

            // Start Jetty Server
            final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(
                    URI.create("http://localhost:8080/"), resourceConfig);

            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                try {
                    log.info("Shutting down the application...");
                    server.shutdownNow();
                    log.info("Server shut down successfully.");
                } catch (final Exception e) {
                    log.error("Unable to stop server.", e);
                }
            }));

            log.info("Application started.");
            Thread.currentThread().join();
        } catch (final InterruptedException e) {
            log.error("Thread interrupted", e);
        }
    }
}
