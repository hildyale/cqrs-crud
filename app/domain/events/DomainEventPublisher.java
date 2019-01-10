package domain.events;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class DomainEventPublisher {
    private ArrayList<Evento> eventos;
    private RabbitMQ rabbitMQ;

    @Inject
    public DomainEventPublisher(RabbitMQ rabbitMQ){
        this.rabbitMQ = rabbitMQ;
        this.eventos = new ArrayList<>();
    }

    public void publish(Evento evento){
        eventos.add(evento);
        rabbitMQ.publish(evento);
        System.out.println(evento.toString());
    }

    public List getEventos() {
        return eventos;
    }

}
