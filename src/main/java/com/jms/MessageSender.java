package main.java.com.jms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

public class MessageSender {
    public static void main(String[] args) {
        try {
            ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
            JmsTemplate template = (JmsTemplate) ctx.getBean("jmsTemplate");
            Destination dest = (Destination) ctx.getBean("destination");
            MessageCreator creator = new MessageCreator() {
                public Message createMessage(Session session) throws JMSException {
                    return session.createTextMessage("Message:Spring JMS Integration");
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
