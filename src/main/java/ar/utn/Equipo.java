package ar.utn;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Equipo {
    private String nombre;

    public Equipo(String nombre) {
        this.nombre = nombre;
    }
    public String toString(){
        return this.nombre;
    }
}
