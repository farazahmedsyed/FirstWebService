package main.java.com.jms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Venturdive on 20/02/2017.
 */
public class Receiver {
    public static  void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        AsyncReceiver asyncReceiver = (AsyncReceiver) ctx.getBean("AsyncReceiver");
        System.out.println("Receiver Class : Main Function");
        System.out.println("Registering Async Receiver");
        asyncReceiver.setReceiver();
        while (true) {}
    }
}
