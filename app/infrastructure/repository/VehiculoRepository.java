package infrastructure.repository;

import com.google.inject.ImplementedBy;
import domain.model.Vehiculo;

import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;

@ImplementedBy(VehiculoRepositoryImpl.class)
public interface VehiculoRepository {
    CompletionStage<Vehiculo> add(Vehiculo vehiculo);
    CompletionStage<Vehiculo> update(Vehiculo vehiculo);
    CompletionStage<String> delete(String placa);
    CompletionStage<Stream<Vehiculo>> list();
    CompletionStage<Vehiculo> select(String placa);
}
