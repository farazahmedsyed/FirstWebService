package main.java.com.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.util.Properties;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;

public class AsyncReceiver implements MessageListener, ExceptionListener
{

    @Autowired
    Destination dest;
    @Autowired
    @Qualifier("queueConnectionFactory")
    QueueConnectionFactory connFactory;
    static QueueConnection queueConn = null;
    public void setReceiver()
    {
       try {
           queueConn = connFactory.createQueueConnection();


           // create a queue session
           QueueSession queueSession = queueConn.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

           // create a queue receiver
           QueueReceiver queueReceiver = queueSession.createReceiver((Queue) dest);

           // set an asynchronous message listener
           AsyncReceiver asyncReceiver = new AsyncReceiver();
           queueReceiver.setMessageListener(asyncReceiver);

           // set an asynchronous exception listener on the connection
           queueConn.setExceptionListener(asyncReceiver);

           // start the connection
           queueConn.start();
       }
       catch (Exception e){
           e.printStackTrace();
       }
    }

    /**
     This method is called asynchronously by JMS when a message arrives
     at the queue. Client applications must not throw any exceptions in
     the onMessage method.
     @param message A JMS message.
     */
    @Override
    public void onMessage(Message message)
    {
        TextMessage msg = (TextMessage) message;
        try {
            if(msg.getText().equals("exit")){
                queueConn.close();
                System.out.println("Sender Exits");
            }else{
                System.out.println("received: " + msg.getText());
            }
        } catch (JMSException ex) {
            ex.printStackTrace();
        }
    }

    /**
     This method is called asynchronously by JMS when some error occurs.
     When using an asynchronous message listener it is recommended to use
     an exception listener also since JMS have no way to report errors
     otherwise.
     @param exception A JMS exception.
     */
    public void onException(JMSException exception)
    {
        System.err.println("an error occurred: " + exception);
    }
}