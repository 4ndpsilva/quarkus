package br.com.quarkus.finder.exception;

import br.com.quarkus.finder.dto.ErrorResponseDTO;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ApiExceptionHandler implements ExceptionMapper<BusinessException> {

    @Override
    public Response toResponse(BusinessException e) {
        Response.Status status = Response.Status.BAD_REQUEST;
        ErrorResponseDTO errorResponse = new ErrorResponseDTO(e.getCause().getMessage(), status.getStatusCode());
        return Response.status(status).entity(errorResponse).build();
    }
}