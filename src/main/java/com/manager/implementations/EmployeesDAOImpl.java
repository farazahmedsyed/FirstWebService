package main.java.com.manager.implementations;

import main.java.com.entities.Employee;
import main.java.com.manager.interfaces.EmployeesDAO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
//@Transactional
public class EmployeesDAOImpl implements EmployeesDAO
{
    public static final Logger LOGGER = Logger.getLogger(EmployeesDAOImpl.class.toString());

    public EmployeesDAO EmployeesDAO(){return  new EmployeesDAOImpl();}


    @PersistenceContext(unitName = "MySQL2")
    private EntityManager entityManager;

    public List<Employee> viewAll() {

        List<Employee> employees =new ArrayList<Employee>();
        String hql;
        hql= "from Employee";
        employees = entityManager.createQuery(hql).getResultList();

        return employees;
    }
    public Employee viewEmpByID(Integer empID) {
      return   entityManager.find(Employee.class,empID);

    }

    public Employee insertEmp(Employee emp){
        try {
            ///throw new RuntimeException("Rollback transaction!");
            entityManager.persist(emp);


        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return emp;
    }
    public Employee updateEmp(Employee emp){

        Employee temp = new Employee();
        try {
            temp = entityManager.find(Employee.class,emp.getEmpID());
            temp.setName(emp.getName());
            temp.setAge(emp.getAge());
            entityManager.persist(temp);
        }
        catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Exception Occured");
            throw e;
        }
        return temp;
    }
}