package main.java.com.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Sender {

    public static  void main(String[] args)
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        MessageSender sender = (MessageSender) ctx.getBean("MessageSender");
        System.out.println("Sender Class : Main Function");
        String message ="Hello Spring JMS";
        System.out.println("Sending Message : " + message);
        sender.sendMessage(message);
    }
}
