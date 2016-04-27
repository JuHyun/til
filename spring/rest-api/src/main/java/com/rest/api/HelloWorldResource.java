package com.rest.api;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * HelloWorld Resource.
 */
@Component
@Path("/hello")
public class HelloWorldResource {

    @GET
    @Path("/world")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello World";
    }
}
