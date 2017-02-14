package main.java.com.users.manager;

import java.util.List;

public interface UsersDAO1
{
   // public void insert(Users users);
  //  public Users findByCustomerId(int userId);
    public List<Users> viewAll();
    public List<Users> viewUserByID(Integer userID);
    public Users insertUser(Users user);
    public Users updateUser(Users user);
}