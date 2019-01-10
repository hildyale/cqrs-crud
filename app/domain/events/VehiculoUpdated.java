package domain.events;

import domain.model.Vehiculo;

public class VehiculoUpdated extends Evento{

    public VehiculoUpdated(Vehiculo vehiculo){
        this.vehiculo = vehiculo;
        this.titulo = "VehiculoUpdated";
    }

}