package main.java.com.manager.implementations;


import main.java.com.entities.User;
import main.java.com.manager.interfaces.UsersDAO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Component
//@Transactional
public class UsersDAOImpl implements UsersDAO
{

  public UsersDAO usersDAO(){return  new UsersDAOImpl();}


    @PersistenceContext(unitName = "MySQL")
    private EntityManager entityManager;

    public List<User> viewAll() {

        List<User> users=new ArrayList<User>();
        String hql;
         hql= "from User";
        users = entityManager.createQuery(hql).getResultList();

        return users;
}
    public User viewUserByID(Integer userID) {
        return   entityManager.find(User.class,userID);

    }
    public User insertUser(User user){
        try {
            entityManager.persist(user);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    public User updateUser(User user){
      User temp = entityManager.find(User.class,user.getUserID());
        temp.setName(user.getName());
        temp.setAge(user.getAge());
        entityManager.persist(temp);
        return temp;
    }
}