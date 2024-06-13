package br.com.quarkus.finder.controller;

import br.com.quarkus.finder.dto.AddressResponseDTO;
import br.com.quarkus.finder.service.AddressService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/addresses")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RegisterRestClient
public class AddressController {
    @Inject
    private AddressService service;

    @GET
    public Response find(@QueryParam("zipCode") String zipCode){
        AddressResponseDTO addressResponseDTO = service.find(zipCode);
        return Response.ok(addressResponseDTO).build();
    }
}