package br.com.body_measurements.controller;

import br.com.body_measurements.client.MetricsClient;
import br.com.body_measurements.dto.UserMetricsDTO;
import br.com.body_measurements.service.UserMetricsService;
import com.fasterxml.jackson.core.JsonProcessingException;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/user-metrics")
public class UserMetricsController implements MetricsClient {

    @Inject
    UserMetricsService service;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@Valid UserMetricsDTO dto) {
        try {
            return Response
                    .status(Response.Status.CREATED)
                    .entity(service.save(dto))
                    .build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        try {
            return Response.ok(service.findAll()).build();
        } catch (JsonProcessingException e) {
            return Response.serverError().build();
        }
    }
}
