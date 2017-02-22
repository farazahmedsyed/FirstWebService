package main.java.com.service;

import main.java.com.entities.Employee;
import main.java.com.entities.User;
import main.java.com.jms.publisher.Publisher;
import main.java.com.manager.interfaces.EmployeesDAO;
import main.java.com.manager.interfaces.UsersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
@Transactional

public class Service {

    public static final Logger LOGGER = Logger.getLogger(Service.class.toString());

    @Autowired
    UsersDAO users;
    @Autowired
    EmployeesDAO employees;
    @Autowired
    Publisher publisher;
    @Autowired
    UserService us;

    public List viewAll(){
        List list = new ArrayList<>();
        list.add(users.viewAll());
        list.add(employees.viewAll());
        return list;
            }

    public List viewByID(Integer id){
        List list = new ArrayList<>();
        list.add(users.viewUserByID(id));
        list.add(employees.viewEmpByID(id));
        return list;
    }

    public List insert(User user,Employee emp){
        user = users.insertUser(user);
        emp = employees.insertEmp(emp);
        List list = new ArrayList<>();
        list.add(user);
        list.add(emp);
        return  list;
    }

    public List update(User user,Employee emp){
        List list = new ArrayList<>();
        try {
           // user= users.updateUser(user);
           // emp=employees.updateEmp(emp);
            System.out.println("In Service");
            us.update(user);
            publisher.sendMessage(user);
            list.add(user);
            list.add(emp);
        }
        catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Exception Occured");
            e.printStackTrace();
            throw e;
        }
        System.out.println("Service return");
        return  list;
    }
}
