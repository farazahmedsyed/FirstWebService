package main.java.com.jms;
import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Properties;
/**
 * Created by Venturdive on 20/02/2017.
 */
public class SynchMessageReceiver {
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
            Destination dest = (Destination) ctx.lookup("java:/jms/queue/ExpiryQueue");

            MessageConsumer receiver = session.createConsumer(dest);
            System.out.println("Waiting for message...");
            connection.start();
            Message msg = receiver.receive(3000);
            if (msg instanceof TextMessage) {
                TextMessage message = (TextMessage) msg;
                System.out.println("Received: " + message.getText());
            }

            connection.close();
            ctx.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
