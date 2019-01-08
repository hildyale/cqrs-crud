# Vehiculo schema

# --- !Ups

CREATE TABLE Vehiculo (
    placa varchar(255) NOT NULL,
    modelo numeric(10,2) NOT NULL,
    tipo varchar(255) NOT NULL,
    marca varchar(255) NOT NULL,
    clase varchar(255) NOT NULL,
    color varchar(255) NOT NULL,
    cilindraje varchar(255) NOT NULL,
    PRIMARY KEY (placa)
);

# --- !Downs

DROP TABLE Vehiculo;