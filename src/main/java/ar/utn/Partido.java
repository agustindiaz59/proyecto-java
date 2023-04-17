package ar.utn;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Partido {
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private int puntosLocal;
    private int puntosVisitante;
    private int puntostotal;


    public Partido(Equipo equipoLocal, int puntosLocal, int puntosVisitante, Equipo equipoVisitante) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.puntosLocal = puntosLocal;
        this.puntosVisitante = puntosVisitante;
    }

    public String toString() {
        return equipoLocal.toString() + ": " + puntosLocal + ", " + equipoVisitante.toString() + ": " + puntosVisitante;
    }

    public String resultado() {
        String ganador;
        if (puntosLocal > puntosVisitante) {
            return ganador = equipoLocal.getNombre();

        } else if (puntosLocal < puntosVisitante) {
            return ganador = equipoVisitante.getNombre();
        } else {
            return ganador = "empate";
            }
        }
    }




