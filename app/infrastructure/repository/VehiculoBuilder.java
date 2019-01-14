package infrastructure.repository;

import domain.model.Vehiculo;

public class VehiculoBuilder {

    private VehiculoBuilder(){}

    public static VehiculoJpa convertirAJpa(Vehiculo vehiculo){
        VehiculoJpa vehiculoJpa = null;
        if(vehiculo != null){
            vehiculoJpa = new VehiculoJpa();
            vehiculoJpa.setPlaca(vehiculo.getPlaca());
            vehiculoJpa.setTipo(vehiculo.getTipo());
            vehiculoJpa.setCilindraje(vehiculo.getCilindraje());
            vehiculoJpa.setColor(vehiculo.getColor());
            vehiculoJpa.setModelo(vehiculo.getModelo());
            vehiculoJpa.setMarca(vehiculo.getMarca());
            vehiculoJpa.setClase(vehiculo.getClase());
            vehiculoJpa.setFechaIngreso(vehiculo.getFechaIngreso());
        }
        return vehiculoJpa;
    }

    public static  Vehiculo convertirADominio(VehiculoJpa vehiculoJpa){
        Vehiculo vehiculo = null;
        if(vehiculoJpa != null){
            vehiculo = new Vehiculo();
            vehiculo.setPlaca(vehiculoJpa.getPlaca());
            vehiculo.setTipo(vehiculoJpa.getTipo());
            vehiculo.setCilindraje(vehiculoJpa.getCilindraje());
            vehiculo.setColor(vehiculoJpa.getColor());
            vehiculo.setModelo(vehiculoJpa.getModelo());
            vehiculo.setMarca(vehiculoJpa.getMarca());
            vehiculo.setClase(vehiculoJpa.getClase());
            vehiculo.setFechaIngreso(vehiculoJpa.getFechaIngreso());
        }
        return vehiculo;
    }
}
