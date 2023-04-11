package ar.utn;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Objects;
@AllArgsConstructor@NoArgsConstructor
public class Pronostico {
    Partido partido;
    Equipo equipo;
    public boolean ganaLocal(boolean b){
        return b && Objects.equals(partido.resultado(equipo), "Felicidades tu equipo ganó");
    }
    public boolean empate(boolean b){
        return b && Objects.equals(partido.resultado(equipo), "Fue un empate");
    }
    public boolean ganaVisitante(boolean b){
        return b && Objects.equals(partido.resultado(equipo), "Fue un empate");
    }
}
