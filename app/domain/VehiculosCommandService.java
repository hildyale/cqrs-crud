package domain;

import domain.model.Vehiculo;
import infrastructure.repository.VehiculoRepository;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;

public class VehiculosCommandService {
    VehiculoRepository repository;

    @Inject
    public VehiculosCommandService(VehiculoRepository repository){
        this.repository = repository;
    }

    public CompletionStage<Vehiculo> addVehiculo(Vehiculo vehiculo){
        return repository.add(vehiculo);
    }

    public CompletionStage<Vehiculo> updateVehiculo(Vehiculo vehiculo){
        return repository.update(vehiculo);
    }

    public CompletionStage<String> deleteVehiculo(String placa){
        return repository.delete(placa);
    }
}
