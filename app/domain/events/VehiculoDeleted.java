package domain.events;

import domain.model.Vehiculo;

public class VehiculoDeleted extends Evento{
    private String placa;
    public VehiculoDeleted(Vehiculo vehiculo){
        this.vehiculo = vehiculo;
        this.titulo = "VehiculoDeleted";
    }

}
