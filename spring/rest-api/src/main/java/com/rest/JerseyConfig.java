package com.rest;

import com.rest.api.HelloWorldResource;
import org.glassfish.jersey.server.ResourceConfig;

import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

/**
 * Jersey Config.
 */
@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        registerEndpoints();
    }

    private void registerEndpoints() {
        register(HelloWorldResource.class);
    }
}
