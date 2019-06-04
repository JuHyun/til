package com.rest.api;

import com.rest.domain.Customer;
import com.rest.service.CustomerService;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * Customer Resource.
 */
@Component
@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {

    private CustomerService customerService;

    @Context
    private UriInfo uriInfo;

    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    @POST
    public Response save(Customer customer) {
        customer = customerService.save(customer);

        URI location = getUri(customer);

        return Response.created(location).build();
    }

    @GET
    @Path("{id}")
    public Customer findOne(@PathParam("id") Long id) {
        return customerService.findOne(id);
    }

    @GET
    public Page<Customer> findAll(
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("size") @DefaultValue("20") int size,
            @QueryParam("sort") @DefaultValue("lastname") List<String> sort,
            @QueryParam("direction") @DefaultValue("asc") String direction) {
        return customerService.findAll(page, size, sort, direction);
    }

    @PUT
    @Path("{id}")
    public Customer update(@PathParam("id") Long id, Customer customer) {
        return customerService.update(id, customer);
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        customerService.delete(id);
        return Response.ok().build();
    }

    private URI getUri(Customer customer) {
        return uriInfo.getAbsolutePathBuilder()
                .path("{id}")
                .resolveTemplate("id", customer.getId())
                .build();
    }
}
