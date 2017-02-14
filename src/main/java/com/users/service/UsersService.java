package main.java.com.users.service;

import main.java.com.users.manager.Users;
import main.java.com.users.manager.UsersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Venturdive on 10/02/2017.
 */
@Component
@Transactional
public class UsersService {

    @Autowired
    UsersDAO users;


    public List viewAllUsers(){
        return users.viewAll();
            }

    public List<Users> viewUserByID(Integer userID){
        return users.viewUserByID(userID);
    }

    public Users insertUser(Users user){
        return users.insertUser(user);
    }

    public Users updateUser(Users user){
        return users.updateUser(user);
    }
}
