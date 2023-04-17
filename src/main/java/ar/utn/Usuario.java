package ar.utn;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Usuario {
    private String nombre;
    private int aciertos = 0;
    private int puntaje = 0;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public String toString() {

        return "Nombre usuario: " + this.nombre + "\n\r" +
                "Puntaje: "+ this.puntaje + "\n\r"+
                "Acietos: "+ this.aciertos;
    }
    public void sumarPuntaje(int puntaje){
        this.aciertos ++;
        this.puntaje += puntaje;
    }
}
