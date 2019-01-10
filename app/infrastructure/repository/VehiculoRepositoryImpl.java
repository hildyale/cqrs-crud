package infrastructure.repository;

import domain.model.Vehiculo;
import play.db.jpa.JPAApi;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
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
        em.persist(vehiculo);
        return vehiculo;
    }

    /*private String delete(EntityManager em, String placa) {
        Query query = em.createQuery("DELETE FROM Vehiculo AS p WHERE p.placa=:placa")
                .setParameter("placa", placa);
        query.executeUpdate();
        return placa;
    }*/

    private Vehiculo delete(EntityManager em, String placa) {
        Vehiculo vehiculo = em.createQuery("SELECT p FROM Vehiculo AS p WHERE p.placa=:placa",Vehiculo.class)
                .setParameter("placa", placa).getSingleResult();
        em.remove(vehiculo);
        return vehiculo;
    }


    private Vehiculo select(EntityManager em, String placa) {
        return em.createQuery("SELECT p FROM Vehiculo AS p WHERE p.placa=:placa",Vehiculo.class)
                .setParameter("placa", placa).getSingleResult();
    }

    private Vehiculo update(EntityManager em, Vehiculo vehiculo){
        Vehiculo vehiculoObtenido = em.createQuery("SELECT p FROM Vehiculo AS p WHERE p.placa=:placa",Vehiculo.class)
                .setParameter("placa", vehiculo.getPlaca()).getSingleResult();
        if(vehiculoObtenido != null){
            em.merge(vehiculo);
        }
        return vehiculo;
    }

    private Stream<Vehiculo> list(EntityManager em) {
        List<Vehiculo> vehiculos = em.createQuery("select p from Vehiculo p", Vehiculo.class).getResultList();
        return vehiculos.stream();
    }

}
