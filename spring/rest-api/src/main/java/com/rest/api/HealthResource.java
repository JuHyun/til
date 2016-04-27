package com.rest.api;

import com.rest.domain.Health;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Health Resource.
 */
@Component
@Path("/health")
@Produces(MediaType.APPLICATION_JSON)
public class HealthResource {

    @GET
    public Health get() {
        Health health = new Health("Strong");
        return health;
    }
}
