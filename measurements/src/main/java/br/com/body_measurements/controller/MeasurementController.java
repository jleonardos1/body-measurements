package br.com.body_measurements.controller;

import br.com.body_measurements.service.MeasurementService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/measurement")
public class MeasurementController {

    @Inject
    MeasurementService service;

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return Response.ok(service.findAll()).build();
    }
}
