package main.java.com.jms;


import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Properties;

/**
 * Created by Venturdive on 20/02/2017.
 */
public class MessageSender {
    private static final String USER = "guestUser";
    private static final String PASSWORD = "password";

    public static void main(String args[]) {
        Properties env = new Properties();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        env.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
        env.put(Context.SECURITY_PRINCIPAL, USER);
        env.put(Context.SECURITY_CREDENTIALS, PASSWORD);

        try {
            Context ctx = new InitialContext(env);
            //http-remoting by default search in java:jboss/exported/ , hence complete path is java:/jboss/exported/jms/RemoteConnectionFactory
            ConnectionFactory factory = (ConnectionFactory) ctx.lookup("jms/RemoteConnectionFactory");
            Connection connection = factory.createConnection(USER, PASSWORD);
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination dest = (Destination) ctx.lookup("jms/queue/testQ");

            MessageProducer sender = session.createProducer(dest);
            TextMessage message = session.createTextMessage("Hello World JMS");
            sender.send(message);
            System.out.println("Sent message to queue.");

            connection.close();
            ctx.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}
