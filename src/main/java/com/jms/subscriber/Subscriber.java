package main.java.com.jms.subscriber;

import main.java.com.entities.Employee;
import main.java.com.entities.User;
import main.java.com.manager.interfaces.EmployeesDAO;
import main.java.com.manager.interfaces.UsersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

/**
 * Created by Venturdive on 20/02/2017.
 */
@Component
//@Transactional
public class Subscriber {
    @Autowired
    EmployeesDAO employee;
    @Autowired
    UsersDAO usersDAO;
    @JmsListener(destination = "testQ")
    //@SendTo("testQ")
    public void onMessage(Message msg) {
        try {
            System.out.println("In Subscriber");
            if (msg instanceof TextMessage) {
                TextMessage txtMsg = (TextMessage) msg;
                System.out.println("Async Subscriber Received: " + txtMsg.getText());
            }
            else if(msg instanceof ObjectMessage){
                ObjectMessage objectMessage = (ObjectMessage) msg;
                User user = (User)objectMessage.getObject();
                Employee emp = new Employee(user);
             //   usersDAO.updateUser(user);
                employee.updateEmp(emp);
                //throw new RuntimeException("Test");
            }
        } catch (Exception e) {
            System.out.println("Exception : "+e.getMessage());
            e.printStackTrace();
            System.out.println("------X-------");
            throw new RuntimeException(e);

        }

    }
}
