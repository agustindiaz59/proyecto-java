package ar.utn;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor@Getter@Setter
public class Pronostico {
    private Equipo local;
    private Equipo visitante;
    private String resultado;
    private Usuario jugador;
    private int numeroPartido;
    public String toString(){
        return local +" "+ visitante +" "+ resultado;
    }
}
