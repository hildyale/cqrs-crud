package domain.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "vehiculo")
public class VehiculoEntity {

    @Id
    private String placa;

    @NotNull
    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private int cilindraje;

    @NotNull
    @Column(nullable = false)
    private String color;

    private String modelo;

    @NotNull
    @Column(nullable = false)
    private String marca;

    @NotNull
    @Column(nullable = false)
    private String clase;

    @Column(name = "fecha_ingreso",nullable = false)
    //@Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngreso;

    public VehiculoEntity(){
        this.fechaIngreso = new Date();
    }


    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    @Override
    public String toString() {
        return "VehiculoEntity{" +
                "placa='" + placa + '\'' +
                ", tipo='" + tipo + '\'' +
                ", cilindraje=" + cilindraje +
                ", color='" + color + '\'' +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", clase='" + clase + '\'' +
                ", fechaIngreso=" + fechaIngreso +
                '}';
    }
}
