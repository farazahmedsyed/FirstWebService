package main.java.com.jms;

import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by Venturdive on 20/02/2017.
 */
public class Subscriber implements MessageListener{

    @Override
    public void onMessage(Message msg) {
        if (msg instanceof TextMessage) {
            try {
                TextMessage txtMsg = (TextMessage) msg;
                System.out.println("Async Received: " + txtMsg.getText());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
