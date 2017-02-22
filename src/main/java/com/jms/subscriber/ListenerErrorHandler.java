package main.java.com.jms.subscriber;

import org.springframework.util.ErrorHandler;

/**
 * Created by Venturdive on 22/02/2017.
 */

public class ListenerErrorHandler implements ErrorHandler {

    @Override
    public void handleError(Throwable t) {
        System.out.println("Error in listener");
        t.printStackTrace();
        System.out.println("----X----");

    }
}