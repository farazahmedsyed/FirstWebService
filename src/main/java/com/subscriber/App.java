package main.java.com.subscriber;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {

    public static  void main(String[] args)
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
//        Subscriber sender = (Subscriber) ctx.getBean("Subscriber");
        System.out.println("Waiting for messages...");


    }
}
