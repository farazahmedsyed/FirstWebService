package main.java.com.jms;
import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Properties;
public class AsynchMessageReceiver {

    private static final String USER = "admin";
    private static final String PASSWORD = "password";

    public static void main(String args[]) {
        Properties env = new Properties();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        env.put(Context.PROVIDER_URL, "remote://localhost:8080");
        env.put(Context.SECURITY_PRINCIPAL, USER);
        env.put(Context.SECURITY_CREDENTIALS, PASSWORD);

        try {
            Context ctx = new InitialContext(env);
            ConnectionFactory factory = (ConnectionFactory) ctx.lookup("java:/ConnectionFactory");
            Connection connection = factory.createConnection(USER, PASSWORD);
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Queue dest = (Queue) ctx.lookup("java:/jms/queue/ExpiryQueue");

            MessageConsumer receiver = session.createConsumer(dest);
            receiver.setMessageListener(new MessageListener() {
                public void onMessage(Message msg) {
                    try {
                        if (msg instanceof TextMessage) {
                            TextMessage message = (TextMessage) msg;
                            System.out.println("Received: " + message.getText());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            System.out.println("Waiting for message...");
            connection.start();

            connection.close();
            ctx.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}