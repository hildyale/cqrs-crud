package application.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.*;
import infrastructure.repository.VehiculoRepository;
import domain.model.Vehiculo;
import static play.libs.Json.toJson;
import static play.libs.Json.fromJson;
import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

public class VehiculosCommandController extends Controller {

    private final VehiculoRepository vehiculoRepository;
    private final HttpExecutionContext ec;
    private final String ERROR_ACTUALIZAR = "Error al actualizar vehiculo";
    private final String ERROR_ELIMINAR = "Error al eliminar vehiculo";
    private final String ERROR_CREAR = "Error al crear vehiculo";

    @Inject
    public VehiculosCommandController(VehiculoRepository vehiculoRepository, HttpExecutionContext ec) {
        this.vehiculoRepository = vehiculoRepository;
        this.ec = ec;
    }

    public CompletionStage<Result> addVehiculo() {
        JsonNode vehiculo = request().body().asJson();
        Vehiculo vehiculoEntity = fromJson(vehiculo, Vehiculo.class);
        return vehiculoRepository.add(vehiculoEntity).thenApplyAsync(p -> ok(toJson(p)), ec.current())
                .exceptionally(error -> internalServerError(ERROR_CREAR+"\n"+error.getMessage()));
    }

    public CompletionStage<Result> updateVehiculo() {
        JsonNode vehiculo = request().body().asJson();
        Vehiculo vehiculoEntity = fromJson(vehiculo, Vehiculo.class);
        return vehiculoRepository.update(vehiculoEntity).thenApplyAsync(p -> ok(toJson(p)), ec.current())
                .exceptionally(error -> internalServerError(ERROR_ACTUALIZAR+"\n"+error.getMessage()));
    }

    public CompletionStage<Result> deleteVehiculo(String placa) {
        return vehiculoRepository.delete(placa).thenApplyAsync(p -> ok(toJson(p)), ec.current())
                .exceptionally(error -> internalServerError(ERROR_ELIMINAR+"\n"+error.getMessage()));
    }

}