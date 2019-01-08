package infrastructure.repository;

import play.db.jpa.JPAApi;
import domain.model.VehiculoEntity;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;
import java.util.stream.Stream;
import static java.util.concurrent.CompletableFuture.supplyAsync;
import static java.util.concurrent.CompletableFuture.runAsync;

public class VehiculoRepository {

    private final JPAApi jpaApi;
    private final DatabaseExecutionContext executor;

    @Inject
    public VehiculoRepository(JPAApi jpaApi, DatabaseExecutionContext executor) {
        this.jpaApi = jpaApi;
        this.executor = executor;
    }

    public CompletionStage<VehiculoEntity> add(VehiculoEntity vehiculoEntity) {
        return supplyAsync(() -> wrap(em -> insert(em, vehiculoEntity)), executor);
    }

    public CompletionStage<VehiculoEntity> delete(VehiculoEntity vehiculoEntity) {
        return supplyAsync(() -> wrap(em -> delete(em, vehiculoEntity)), executor);
    }

    public CompletionStage<VehiculoEntity> update(VehiculoEntity vehiculoEntity) {
        return supplyAsync(() -> wrap(em -> update(em, vehiculoEntity)), executor);
    }

    public CompletionStage<Stream<VehiculoEntity>> list() {
        return supplyAsync(() -> wrap(em -> list(em)), executor);
    }

    private <T> T wrap(Function<EntityManager, T> function) {
        return jpaApi.withTransaction(function);
    }

    private VehiculoEntity insert(EntityManager em, VehiculoEntity vehiculoEntity) {
        em.persist(vehiculoEntity);
        return vehiculoEntity;
    }

    private VehiculoEntity delete(EntityManager em, VehiculoEntity vehiculoEntity) {
        /*if(em.contains(vehiculoEntity)){
            em.remove(vehiculoEntity);
        }*/
        Query query = em.createQuery("DELETE FROM VehiculoEntity AS p WHERE p.placa=:placa")
                .setParameter("placa",vehiculoEntity.getPlaca());
        query.executeUpdate();
        return vehiculoEntity;
    }

    private VehiculoEntity update(EntityManager em, VehiculoEntity vehiculoEntity){
        if(em.contains(vehiculoEntity)){
            em.merge(vehiculoEntity);
        }
        return vehiculoEntity;
    }

    private Stream<VehiculoEntity> list(EntityManager em) {
        List<VehiculoEntity> vehiculos = em.createQuery("select p from VehiculoEntity p", VehiculoEntity.class).getResultList();
        return vehiculos.stream();
    }

}
