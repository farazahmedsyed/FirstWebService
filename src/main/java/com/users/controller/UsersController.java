package main.java.com.users.controller;

/**
 * Created by Venturdive on 08/02/2017.
 */

import main.java.com.users.manager.Users;
import main.java.com.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
@Path("/users")
public class UsersController
{
    @Autowired
    UsersService usersService;

    @Path("/{userID}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Users> viewUsers(@PathParam("userID") Integer userID) {
        return usersService.viewUserByID(userID);
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Users> viewUsers() {
        return usersService.viewAllUsers();
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Users insertUser(Users user) {
        return usersService.insertUser(user);
    }
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Users updateUser(Users user){
        return usersService.updateUser(user);
    }

}
