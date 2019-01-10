package domain.services;

import domain.model.Vehiculo;
import infrastructure.repository.VehiculoRepository;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;

public class VehiculosQueryService {
    VehiculoRepository repository;

    @Inject
    public VehiculosQueryService(VehiculoRepository repository){
        this.repository = repository;
    }

    public CompletionStage<Stream<Vehiculo>> getVehiculos(){
        return repository.list();
    }

    public CompletionStage<Vehiculo> getVehiculo(String placa){
        return repository.select(placa);
    }
}
