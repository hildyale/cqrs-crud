package domain.events;

import domain.model.Vehiculo;

public abstract class Evento {
    public String titulo;
    public Vehiculo vehiculo;

    @Override
    public String toString() {
        return "Evento{" +
                "titulo='" + titulo + '\'' +
                ", vehiculo=" + vehiculo.toString() +
                '}';
    }
}
