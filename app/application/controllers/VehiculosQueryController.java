package application.controllers;

import infrastructure.repository.VehiculoRepository;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

import static play.libs.Json.toJson;

public class VehiculosQueryController extends Controller {

    private final VehiculoRepository vehiculoRepository;
    private final HttpExecutionContext ec;

    @Inject
    public VehiculosQueryController(VehiculoRepository vehiculoRepository, HttpExecutionContext ec) {
        this.vehiculoRepository = vehiculoRepository;
        this.ec = ec;
    }

    public CompletionStage<Result> getVehiculos() {
        return vehiculoRepository.list().thenApplyAsync(Stream ->
                        ok(toJson(Stream.collect(Collectors.toList())))
                        , ec.current()
                    );
    }

    public CompletionStage<Result> getVehiculo(String placa) {
        return vehiculoRepository.select(placa).thenApplyAsync(vehiculo ->
                        ok(toJson(vehiculo))
                , ec.current()
        ).exceptionally(error -> internalServerError(error.getMessage()));
    }

}