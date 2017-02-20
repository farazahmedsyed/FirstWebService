package main.java.com.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

public class MessageSender {


    @Autowired
    private JmsTemplate template;
    @Autowired
    private Destination dest;
    public void sendMessage(String message) {
        try {
            MessageCreator creator = new MessageCreator() {
                public Message createMessage(Session session) throws JMSException {
                    return session.createTextMessage(message);
                }
            };
            template.send(dest, creator);
            System.out.println("Message sent.");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
