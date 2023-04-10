package ar.utn;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter@Setter
public class Partido {
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private int puntosLocal;
    private int puntosVisitante;

    public Partido(Equipo equipoLocal, int puntosLocal, int puntosVisitante,Equipo equipoVisitante) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.puntosLocal = puntosLocal;
        this.puntosVisitante = puntosVisitante;
    }

    public String toString(){
        return equipoLocal.toString() +": "+ puntosLocal +", "+  equipoVisitante.toString()+": "+puntosVisitante;
    }
    public String resultado(Equipo e){
        String ganador;
        if(Objects.equals(e.getNombre(), equipoLocal.getNombre()) || Objects.equals(e.getNombre(), equipoVisitante.getNombre())){
            if(puntosLocal > puntosVisitante){
                ganador = equipoLocal.getNombre();
            } else if (puntosLocal < puntosVisitante) {
                ganador = equipoVisitante.getNombre();
            }else {ganador = "empate";}

            if(Objects.equals(ganador, e.getNombre())){
                return "Felicidades tu equipo ganó";
            } else if (Objects.equals(ganador, "empate")) {
                return "Fue un empate";
            }else {
                return "Tu equipo perdió";
            }
        }else{return "Ese equipo no está en juego";}
    }

}
