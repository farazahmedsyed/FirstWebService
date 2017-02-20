package main.java.com.manager.interfaces;

import main.java.com.entities.User;

import java.util.List;

public interface UsersDAO
{
    public List<User> viewAll();
    public User viewUserByID(Integer userID);
    public User insertUser(User user);
    public User updateUser(User user);
}