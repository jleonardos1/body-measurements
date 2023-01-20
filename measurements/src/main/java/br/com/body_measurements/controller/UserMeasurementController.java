package br.com.body_measurements.controller;

import br.com.body_measurements.service.UserMeasurementService;
import br.com.body_measurements.dto.UserMeasurementDTO;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/user-measurement")
public class UserMeasurementController {

    @Inject
    UserMeasurementService service;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@Valid UserMeasurementDTO userMeasurementDTO) {
        return Response
                .status(Response.Status.CREATED)
                .entity(service.save(userMeasurementDTO))
                .build();
    }

    @GET
    @Path("/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByUserId(@PathParam("userId") Long userId) {
        return Response.ok(service.findByUserId(userId)).build();
    }

    @DELETE
    @Path("/{userMeasurementId}")
    public Response delete(@PathParam("userMeasurementId") Long userMeasurementId) {
        service.delete(userMeasurementId);
        return Response.ok().build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@Valid UserMeasurementDTO userMeasurementDTO) {
        return Response
                .status(Response.Status.CREATED)
                .entity(service.update(userMeasurementDTO))
                .build();
    }
}
