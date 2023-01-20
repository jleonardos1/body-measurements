package br.com.body_measurements.client;

import br.com.body_measurements.dto.UserMetricsDTO;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RegisterRestClient
@Path("/metrics")
public interface MetricsClient {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response save(@Valid UserMetricsDTO dto);
}
