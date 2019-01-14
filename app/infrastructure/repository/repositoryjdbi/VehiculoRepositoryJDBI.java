package infrastructure.repository.repositoryjdbi;

import domain.model.Vehiculo;
import domain.repository.VehiculoRepository;
import infrastructure.repository.DatabaseExecutionContext;
import infrastructure.repository.VehiculoBuilder;
import infrastructure.repository.VehiculoJpa;
import org.jdbi.v3.core.Jdbi;
import javax.inject.Inject;
import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;
import static java.util.concurrent.CompletableFuture.supplyAsync;

public class VehiculoRepositoryJDBI implements VehiculoRepository {

    private Jdbi jdbi;
    private final DatabaseExecutionContext executor;

    @Inject
    public VehiculoRepositoryJDBI(DatabaseExecutionContext executor){
        this.jdbi = Jdbi.create("jdbc:mysql://localhost:3306/prueba?serverTimezone=UTC","root","");
        this.executor = executor;
    }

    @Override
    public CompletionStage<Stream<Vehiculo>> list() {
        return supplyAsync(() -> jdbi.withHandle(handle ->
                handle.createQuery("select * from Vehiculo")
                        .mapToBean(VehiculoJpa.class)
                        .list().stream().map(VehiculoBuilder::convertirADominio)
                        ), executor);
    }

    @Override
    public CompletionStage<Vehiculo> select(String placa) {
        return supplyAsync(() -> VehiculoBuilder.convertirADominio(jdbi.withHandle(handle ->
                        handle.createQuery("SELECT * FROM Vehiculo WHERE placa=:placa")
                                .bind("placa",placa).mapToBean(VehiculoJpa.class).findOnly()))
                , executor);
    }

    @Override
    public CompletionStage<Vehiculo> add(Vehiculo vehiculo) {
        return supplyAsync(() -> jdbi.withHandle(handle -> {
                    handle.createUpdate("insert into Vehiculo (placa, cilindraje,clase,color,fecha_ingreso,marca,modelo,tipo) " +
                            "values (:placa, :cilindraje,:clase,:color,:fechaIngreso, :marca,:modelo,:tipo)")
                            .bindBean(VehiculoBuilder.convertirAJpa(vehiculo))
                            .execute();
                    return vehiculo;
                })
                , executor);
    }

    @Override
    public CompletionStage<Vehiculo> update(Vehiculo vehiculo) {
        return supplyAsync(() -> jdbi.withHandle(handle -> {
                    handle.createUpdate("UPDATE Vehiculo SET cilindraje=:cilindraje," +
                            "clase=:clase," +
                            "color=:color," +
                            "fecha_ingreso=:fechaIngreso," +
                            "marca=:marca," +
                            "modelo=:modelo," +
                            "tipo=:tipo " +
                            "WHERE placa = :placa")
                            .bindBean(VehiculoBuilder.convertirAJpa(vehiculo))
                            .execute();
                    return vehiculo;
                })
                , executor);
    }

    @Override
    public CompletionStage<Vehiculo> delete(String placa) {
        return supplyAsync(() -> jdbi.inTransaction(handle -> {
                    handle.createUpdate("DELETE FROM Vehiculo WHERE placa = :placa")
                            .bind("placa",placa)
                            .execute();
                    Vehiculo vehiculo = new Vehiculo();
                    vehiculo.setPlaca(placa);
                    return vehiculo;
                })
                , executor);
    }

}