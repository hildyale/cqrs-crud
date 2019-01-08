package application.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.*;
import infrastructure.repository.VehiculoRepository;
import domain.model.VehiculoEntity;
import static play.libs.Json.toJson;
import static play.libs.Json.fromJson;
import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

public class VehiculosController extends Controller {

    private final VehiculoRepository vehiculoRepository;
    private final HttpExecutionContext ec;

    @Inject
    public VehiculosController(VehiculoRepository vehiculoRepository, HttpExecutionContext ec) {
        this.vehiculoRepository = vehiculoRepository;
        this.ec = ec;
    }

    public CompletionStage<Result> addVehiculo() {
        JsonNode vehiculo = request().body().asJson();
        VehiculoEntity vehiculoEntity = fromJson(vehiculo, VehiculoEntity.class);
        return vehiculoRepository.add(vehiculoEntity).thenApplyAsync(p -> ok(toJson(p)), ec.current())
                .exceptionally(p -> internalServerError(p.getMessage()));
    }

    public CompletionStage<Result> updateVehiculo() {
        JsonNode vehiculo = request().body().asJson();
        VehiculoEntity vehiculoEntity = fromJson(vehiculo, VehiculoEntity.class);
        return vehiculoRepository.update(vehiculoEntity).thenApplyAsync(p -> ok(toJson(p)), ec.current())
                .exceptionally(p -> internalServerError(p.getMessage()));
    }

    public CompletionStage<Result> deleteVehiculo() {
        JsonNode vehiculo = request().body().asJson();
        VehiculoEntity vehiculoEntity = fromJson(vehiculo, VehiculoEntity.class);
        System.out.println(vehiculoEntity.toString());
        return vehiculoRepository.delete(vehiculoEntity).thenApplyAsync(p -> ok(toJson(p)), ec.current())
                .exceptionally(p -> internalServerError(p.getMessage()));
    }

}