package domain.services;

import domain.events.DomainEventPublisher;
import domain.events.VehiculoCreated;
import domain.events.VehiculoDeleted;
import domain.events.VehiculoUpdated;
import domain.model.Vehiculo;
import infrastructure.repository.VehiculoRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.concurrent.CompletionStage;

public class VehiculosCommandService {
    VehiculoRepository repository;
    DomainEventPublisher domainEventPublisher;

    @Inject
    public VehiculosCommandService(VehiculoRepository repository,DomainEventPublisher domainEventPublisher){
        this.repository = repository;
        this.domainEventPublisher = domainEventPublisher;
    }

    public CompletionStage<Vehiculo> add(Vehiculo vehiculo){
        CompletionStage<Vehiculo> result = repository.add(vehiculo);
        result.thenRun(() -> domainEventPublisher.publish(new VehiculoCreated(vehiculo)));
        return result;
    }

    public CompletionStage<Vehiculo> update(Vehiculo vehiculo){
        CompletionStage<Vehiculo> result = repository.update(vehiculo);
        result.thenRun(() -> domainEventPublisher.publish(new VehiculoUpdated(vehiculo)));
        return result;
    }

    public CompletionStage<Vehiculo> delete(String placa){
        CompletionStage<Vehiculo> result = repository.delete(placa);
        result.thenAccept((vehiculo) -> domainEventPublisher.publish(new VehiculoDeleted(vehiculo)));
        return result;
    }
}
