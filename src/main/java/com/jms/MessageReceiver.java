package main.java.com.jms;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.*;
public class MessageReceiver  {
    public static void main(String[] args) {
      System.out.print("Message Receiver");
      ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        JmsTemplate template = (JmsTemplate) ctx.getBean("jmsTemplate");
        Destination dest = (Destination) ctx.getBean("destination");
        //template.setM
       Message msg = template.receive(dest);
        if (msg instanceof TextMessage) {
            try {
                TextMessage txtMsg = (TextMessage) msg;
                System.out.println("Received: " + txtMsg.getText());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
