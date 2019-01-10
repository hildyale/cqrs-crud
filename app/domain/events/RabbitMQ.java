package domain.events;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;

import javax.inject.Singleton;

@Singleton
public class RabbitMQ {
    private final String userName = "guest";
    private final String password = "guest";
    private final String virtualHost = "/";
    private final String hostName = "localhost";
    private final int portNumber = 5672;
    private final ConnectionFactory factory;
    private final static String QUEUE_NAME = "Eventos";

    public RabbitMQ(){
        factory = new ConnectionFactory();
        //factory.setUsername(userName);
        //factory.setPassword(password);
        //factory.setVirtualHost(virtualHost);
        factory.setHost(hostName);
        //factory.setPort(portNumber);
    }

    public void publish(Evento evento){
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
                channel.queueDeclare(QUEUE_NAME,
                                    false,
                                    false,
                                    false,
                                        null);
                String message = evento.toString();
                channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
