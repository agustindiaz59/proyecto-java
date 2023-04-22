package ar.utn;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Set;

@NoArgsConstructor@Getter@Setter
public class Prode {
    private HashMap<String,Usuario> jugadores = new HashMap<>();
    private Ronda ronda;
    private Set<String> jugadoresId = this.jugadores.keySet();

    public Prode(Ronda ronda) {
        this.ronda = ronda;
    }

    public void agregarJugador(Usuario j){
        jugadores.put(j.getNombre(),j);
    }
    public boolean existeJugador(Usuario j){
        return jugadores.containsKey(j.getNombre());
    }
    public void calcularPuntos(int puntos){
        for (String j : jugadoresId) {
            jugadores.get(j).calcularAciertos(this.ronda);
            jugadores.get(j).sumarPuntaje(puntos);
        }
    }
    public Usuario ganador(){
        Usuario mayor = null;
        for (String j : jugadoresId) {
            if(mayor == null || mayor.getPuntaje() < jugadores.get(j).getPuntaje()){
                mayor = jugadores.get(j);
            }
        }
        return mayor;
    }

}
