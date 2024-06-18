package br.com.quarkus.finder.exception.handler;

import br.com.quarkus.finder.dto.ErrorDetailDTO;
import br.com.quarkus.finder.dto.ErrorResponseDTO;
import br.com.quarkus.finder.exception.CEPNotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.List;

@Provider
public class ResourceNotFoundExceptionHandler implements ExceptionMapper<CEPNotFoundException>{
    @Override
    public Response toResponse(CEPNotFoundException ex) {
        Response.Status status = Response.Status.NOT_FOUND;
        ErrorDetailDTO detailDTO = new ErrorDetailDTO(ex.getMessage());
        ErrorResponseDTO errorResponse = new ErrorResponseDTO(status.getStatusCode(), List.of(detailDTO));
        return Response.status(status).entity(errorResponse).build();
    }
}