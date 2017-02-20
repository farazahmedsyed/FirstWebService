package main.java.com.subscriber;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.TextMessage;

/**
 * Created by Venturdive on 20/02/2017.
 */
@Component
//@EnableJms
public class Subscriber  {

    @JmsListener(destination = "testTopic")
    public void onMessage(Message msg) {
        if (msg instanceof TextMessage) {
            try {
                TextMessage txtMsg = (TextMessage) msg;
                System.out.println("Async Subscriber Received: " + txtMsg.getText());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
