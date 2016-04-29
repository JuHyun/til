package com.rest.backdoor;

import com.rest.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * BackdoorResource.
 */
@Component
@Path("/_backdoor")
@Produces(MediaType.APPLICATION_JSON)
public class BackdoorResource {

    @Autowired
    private CustomerService customerService;

    @GET
    @Path("/create/{firstname}/{lastname}")
    public Response create(@PathParam("firstname") String firstname,
                           @PathParam("lastname") String lastname) {
        customerService.save(firstname, lastname);
        return Response.ok().build();
    }
}
