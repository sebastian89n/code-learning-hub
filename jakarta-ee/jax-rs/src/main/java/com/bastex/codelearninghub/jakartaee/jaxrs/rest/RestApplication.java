package com.bastex.codelearninghub.jakartaee.jaxrs.rest;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

/**
 * ApplicationPath defines global API prefix for each endpoint
 */
@ApplicationPath("api")
public class RestApplication extends Application {
}
