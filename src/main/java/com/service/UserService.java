package main.java.com.service;

import main.java.com.entities.Employee;
import main.java.com.entities.User;
import main.java.com.manager.interfaces.UsersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * Created by Venturdive on 21/02/2017.
 */
@Component
@Transactional
public class UserService {
    @Autowired
    UsersDAO users;
    public List update(User user){
        List list = new ArrayList<>();
        try {
            //user= users.updateUser(user);
            // emp=employees.updateEmp(emp);
            System.out.println("In User Service");
            users.updateUser(user);
            list.add(user);

        }
        catch (Exception e) {

            throw e;
        }
        System.out.println("User Service return");
        //throw new RuntimeException("test");
        return  list;
    }
}
