package main.java.com.exception.mapper;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServlet;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
@Provider
@Component
public class GenericExceptionMapper extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Provider
    public class MyNullPointerExceptionMapper implements ExceptionMapper<NullPointerException> {

        @Override
        public Response toResponse(NullPointerException e) {

            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())
                    .type(MediaType.TEXT_PLAIN)
                    .entity("Catching in MyNullPointerExceptionMapper : "+ e.getMessage())
                    .build();
        }
    }
}