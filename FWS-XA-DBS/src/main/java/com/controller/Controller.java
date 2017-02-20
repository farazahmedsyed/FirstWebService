package main.java.com.controller;

import main.java.com.entities.Employee;
import main.java.com.entities.User;
import main.java.com.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
@Path("/data")
public class Controller
{
    @Autowired
    Service service;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List viewByID(@PathParam("id") Integer id) {
        return service.viewByID(id);
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List viewAll() {
        return service.viewAll();
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List insert(User user) {
        Employee emp=new Employee();
        emp.setName(user.getName());
        emp.setAge(user.getAge());
        return service.insert(user,emp);
    }
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List update(User user){
        try {
            Employee emp=new Employee(user);
            return service.update(user,emp);
        }
        catch (Exception e) {
            return null;
        }
    }

}
