package application.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import domain.services.VehiculosCommandService;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.*;
import domain.model.Vehiculo;
import static play.libs.Json.toJson;
import static play.libs.Json.fromJson;
import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

public class VehiculosCommandController extends Controller {

    private final VehiculosCommandService vehiculosCommandService;

    private final HttpExecutionContext ec;
    private final String ERROR_ACTUALIZAR = "Error al actualizar vehiculo";
    private final String ERROR_ELIMINAR = "Error al eliminar vehiculo";
    private final String ERROR_CREAR = "Error al crear vehiculo";

    @Inject
    public VehiculosCommandController(VehiculosCommandService vehiculosCommandService, HttpExecutionContext ec) {
        this.vehiculosCommandService = vehiculosCommandService;
        this.ec = ec;
    }

    public CompletionStage<Result> addVehiculo() {
        JsonNode vehiculo = request().body().asJson();
        Vehiculo vehiculoEntity = fromJson(vehiculo, Vehiculo.class);
        return vehiculosCommandService.add(vehiculoEntity).thenApplyAsync(p -> ok(toJson(p)), ec.current())
                .exceptionally(error -> internalServerError(ERROR_CREAR+"\n"+error.getMessage()));
    }

    public CompletionStage<Result> updateVehiculo() {
        JsonNode vehiculo = request().body().asJson();
        Vehiculo vehiculoEntity = fromJson(vehiculo, Vehiculo.class);
        return vehiculosCommandService.update(vehiculoEntity).thenApplyAsync(p -> ok(toJson(p)), ec.current())
                .exceptionally(error -> internalServerError(ERROR_ACTUALIZAR+"\n"+error.getMessage()));
    }

    public CompletionStage<Result> deleteVehiculo(String placa) {
        return vehiculosCommandService.delete(placa).thenApplyAsync(p -> ok(toJson(p)), ec.current())
                .exceptionally(error -> internalServerError(ERROR_ELIMINAR+"\n"+error.getMessage()));
    }



}