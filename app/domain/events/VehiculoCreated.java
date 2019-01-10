package domain.events;

import domain.model.Vehiculo;

public class VehiculoCreated extends Evento{

    public VehiculoCreated(Vehiculo vehiculo){
        this.vehiculo = vehiculo;
        this.titulo = "VehiculoCreated";
    }

}
