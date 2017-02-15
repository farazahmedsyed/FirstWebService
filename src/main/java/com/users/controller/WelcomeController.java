package main.java.com.users.controller;

import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Venturdive on 10/02/2017.
 */
@Controller
@Path("/")
public class WelcomeController {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String welcome() {
        return "WebService";
   }
}
