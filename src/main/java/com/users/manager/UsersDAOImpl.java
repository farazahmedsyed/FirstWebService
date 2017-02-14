package main.java.com.users.manager;



import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Component;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

;

@Component
public class UsersDAOImpl implements UsersDAO
{

  public UsersDAO usersDAO(){return  new UsersDAOImpl();}


    @PersistenceContext(name = "MySQL")
    private EntityManager entityManager;

    public List<Users> viewAll() {

        List<Users> users=new ArrayList<Users>();
        String hql;
         hql= "from Users";
        users = entityManager.createQuery(hql).getResultList();

        return users;
}
    public List<Users> viewUserByID(Integer userID) {
        List<Users> users=new ArrayList<Users>();
        String hql;
        hql= "from Users WHERE USER_ID= :id";
        Query query=entityManager.createQuery(hql);
        query.setParameter("id",userID);
        users = query.getResultList();

        return users;
    }

    public Users insertUser(Users user){
        try {

            entityManager.persist(user);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    public Users updateUser(Users user){
       String hql="UPDATE Users set NAME= :name, AGE= :age WHERE USER_ID= :id";
        Query query = entityManager.createQuery(hql);
        query.setParameter("name",user.getName());
        query.setParameter("age",user.getAge());
        query.setParameter("id",user.getUserID());
        query.executeUpdate();
        user=entityManager.merge(user);
        return user;
    }
}