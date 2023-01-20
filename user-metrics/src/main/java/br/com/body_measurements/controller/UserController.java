package br.com.body_measurements.controller;

import br.com.body_measurements.dto.UserDTO;
import br.com.body_measurements.service.UserService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/user")
public class UserController {

    @Inject
    UserService service;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@Valid UserDTO userDTO) {
        return Response
                .status(Response.Status.CREATED)
                .entity(service.save(userDTO))
                .build();
    }

    @GET
    @Path("/email/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByEmail(@PathParam("email") String email) {
        return Response.ok(service.findByEmail(email)).build();
    }

}
