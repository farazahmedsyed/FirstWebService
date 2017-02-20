package main.java.com.controller;

import org.springframework.stereotype.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Controller
@Path("/")
public class WelcomeController {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List welcome() {
        List welcome=new ArrayList<>();
       welcome.add("Welcome");
        welcome.add("First Restful WebService");
        return  welcome;
   }
    @GET
    @Path("/check")
    @Produces(MediaType.APPLICATION_JSON)
    public String checkMonitor() {
        throw new RuntimeException("Monitor not available");
    }

}
