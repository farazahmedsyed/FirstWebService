package main.java.com.jms.publisher;

import main.java.com.entities.Employee;
import main.java.com.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
@Component
@Transactional
public class Publisher {

    @Autowired
    private JmsTemplate template;
    public void sendMessage(User user) {
        try {
            System.out.println("In Publisher");
            MessageCreator creator = new MessageCreator() {
                public Message createMessage(Session session) throws JMSException {
                    return  session.createObjectMessage(user);
                    //return session.createTextMessage(message);
                }
            };
            template.send(creator);
            System.out.println("Message sent.");
        }
        catch (Exception e){
           // e.printStackTrace();
           System.out.println("Exception : Publisher : " + e.getMessage());
            throw new RuntimeException("Test");
        }
    }
}
