package httpErrors;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class FlightNotFoundExceptionMapper implements ExceptionMapper<FlightNotFoundException> {

    @Override
    public Response toResponse(FlightNotFoundException exception) {
        return Response.status(404).entity("{\"code\": 404, \"message\": \"" + exception.getMessage() + "\"}").build();
    }

}
