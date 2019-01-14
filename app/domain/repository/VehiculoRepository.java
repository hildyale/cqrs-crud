package domain.repository;

import com.google.inject.ImplementedBy;
import domain.model.Vehiculo;
import infrastructure.repository.repositoryjdbi.VehiculoRepositoryJDBI;

import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;

@ImplementedBy(VehiculoRepositoryJDBI.class)
public interface VehiculoRepository {
    CompletionStage<Vehiculo> add(Vehiculo vehiculo);
    CompletionStage<Vehiculo> update(Vehiculo vehiculo);
    CompletionStage<Vehiculo> delete(String placa);
    CompletionStage<Stream<Vehiculo>> list();
    CompletionStage<Vehiculo> select(String placa);
}
