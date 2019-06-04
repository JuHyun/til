package com.rest;

import com.rest.api.CustomerResource;
import com.rest.api.HealthResource;
import com.rest.backdoor.BackdoorResource;
import org.glassfish.jersey.server.ResourceConfig;

import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

/**
 * Jersey Config.
 */
@Component
@ApplicationPath("/")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        registerEndpoints();
    }

    private void registerEndpoints() {
        register(HealthResource.class);
        register(CustomerResource.class);
        register(BackdoorResource.class);
    }
}
