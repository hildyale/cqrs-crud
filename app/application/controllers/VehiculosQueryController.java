package application.controllers;

import domain.events.DomainEventPublisher;
import domain.services.VehiculosQueryService;
import infrastructure.repository.VehiculoRepository;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

import static play.libs.Json.toJson;

public class VehiculosQueryController extends Controller {

    private final VehiculosQueryService vehiculosQueryService;
    private final HttpExecutionContext ec;
    private final DomainEventPublisher domainEventPublisher;

    @Inject
    public VehiculosQueryController(VehiculosQueryService vehiculosQueryService, HttpExecutionContext ec,DomainEventPublisher domainEventPublisher) {
        this.vehiculosQueryService = vehiculosQueryService;
        this.ec = ec;
        this.domainEventPublisher = domainEventPublisher;
    }

    public CompletionStage<Result> getVehiculos() {
        return vehiculosQueryService.getVehiculos().thenApplyAsync(Stream ->
                        ok(toJson(Stream.collect(Collectors.toList())))
                        , ec.current()
                    );
    }

    public CompletionStage<Result> getVehiculo(String placa) {
        return vehiculosQueryService.getVehiculo(placa).thenApplyAsync(vehiculo ->
                        ok(toJson(vehiculo))
                , ec.current()
        ).exceptionally(error -> internalServerError(error.getMessage()));
    }

    public Result eventos(){
        return ok(toJson(domainEventPublisher.getEventos()));
    }

}