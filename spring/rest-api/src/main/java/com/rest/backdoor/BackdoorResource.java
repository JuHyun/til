package com.rest.backdoor;

import com.rest.domain.Customer;
import com.rest.repository.CustomerRepository;
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
@Produces(MediaType.TEXT_PLAIN)
public class BackdoorResource {

    @Autowired
    private CustomerService customerService;

    @GET
    @Path("/create")
    public Response createCustomer() {
//        customerService.save("aaa", "bbb");
        return Response.ok().build();
    }
}
