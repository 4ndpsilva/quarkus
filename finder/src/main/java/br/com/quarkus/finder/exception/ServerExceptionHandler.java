package br.com.quarkus.finder.exception;

import br.com.quarkus.finder.dto.ErrorResponseDTO;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ServerExceptionHandler implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception e) {
        Response.Status status = Response.Status.INTERNAL_SERVER_ERROR;
        ErrorResponseDTO errorResponse = new ErrorResponseDTO(e.getMessage(), status.getStatusCode());
        return Response.status(status).entity(errorResponse).build();
    }
}