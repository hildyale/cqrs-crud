package infrastructure.repository.repositoryjpa;

import domain.model.Vehiculo;
import domain.repository.VehiculoRepository;
import infrastructure.repository.DatabaseExecutionContext;
import infrastructure.repository.VehiculoBuilder;
import infrastructure.repository.VehiculoJpa;
import play.db.jpa.JPAApi;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;
import java.util.stream.Stream;
import static java.util.concurrent.CompletableFuture.supplyAsync;

public class VehiculoRepositoryImpl implements VehiculoRepository {

    private final JPAApi jpaApi;
    private final DatabaseExecutionContext executor;

    @Inject
    public VehiculoRepositoryImpl(JPAApi jpaApi, DatabaseExecutionContext executor) {
        this.jpaApi = jpaApi;
        this.executor = executor;
    }

    @Override
    public CompletionStage<Vehiculo> add(Vehiculo vehiculo) {
        return supplyAsync(() -> wrap(em -> insert(em, vehiculo)), executor);
    }

    @Override
    public CompletionStage<Vehiculo> delete(String placa) {
        return supplyAsync(() -> wrap(em -> delete(em, placa)), executor);
    }

    @Override
    public CompletionStage<Vehiculo> update(Vehiculo vehiculo) {
        return supplyAsync(() -> wrap(em -> update(em, vehiculo)), executor);
    }

    @Override
    public CompletionStage<Stream<Vehiculo>> list() {
        return supplyAsync(() -> wrap(em -> list(em)), executor);
    }
    public CompletionStage<Vehiculo> select(String placa) {
        return supplyAsync(() -> wrap(em -> select(em,placa)), executor);
    }

    private <T> T wrap(Function<EntityManager, T> function) {
        return jpaApi.withTransaction(function);
    }


    private Vehiculo insert(EntityManager em, Vehiculo vehiculo) {
        em.persist(VehiculoBuilder.convertirAJpa(vehiculo));
        return vehiculo;
    }

    /*private String delete(EntityManager em, String placa) {
        Query query = em.createQuery("DELETE FROM Vehiculo AS p WHERE p.placa=:placa")
                .setParameter("placa", placa);
        query.executeUpdate();
        return placa;
    }*/

    private Vehiculo delete(EntityManager em, String placa) {
        VehiculoJpa vehiculoJpa = em.createQuery("SELECT p FROM VehiculoJpa AS p WHERE p.placa=:placa", VehiculoJpa.class)
                .setParameter("placa", placa).getSingleResult();
        em.remove(vehiculoJpa);
        return VehiculoBuilder.convertirADominio(vehiculoJpa);
    }


    private Vehiculo select(EntityManager em, String placa) {
        return VehiculoBuilder.convertirADominio(em.createQuery("SELECT p FROM VehiculoJpa AS p WHERE p.placa=:placa",VehiculoJpa.class)
                .setParameter("placa", placa).getSingleResult());
    }

    private Vehiculo update(EntityManager em, Vehiculo vehiculo){
        VehiculoJpa vehiculoObtenido = em.createQuery("SELECT p FROM VehiculoJpa AS p WHERE p.placa=:placa",VehiculoJpa.class)
                .setParameter("placa", vehiculo.getPlaca()).getSingleResult();
        if(vehiculoObtenido != null){
            em.merge(VehiculoBuilder.convertirAJpa(vehiculo));
        }
        return vehiculo;
    }

    private Stream<Vehiculo> list(EntityManager em) {
        List<VehiculoJpa> vehiculos = em.createQuery("select p from VehiculoJpa p", VehiculoJpa.class).getResultList();
        return vehiculos.stream().map(VehiculoBuilder::convertirADominio);
    }

}
