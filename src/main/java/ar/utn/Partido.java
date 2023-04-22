package ar.utn;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Partido {
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private int puntosLocal;
    private int puntosVisitante;
    private int numeroPartido;


    public Partido(Equipo equipoLocal, int puntosLocal, int puntosVisitante, Equipo equipoVisitante,int numeroPartido) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.puntosLocal = puntosLocal;
        this.puntosVisitante = puntosVisitante;
        this.numeroPartido = numeroPartido;
    }
    public String resultado() {
        String ganador;
        if (puntosLocal > puntosVisitante) {
            return ganador = "L";
        } else if (puntosLocal < puntosVisitante) {
            return ganador = "V";
        } else {
            return ganador = "E";
        }
    }
    public String toString() {
        return equipoLocal.toString() + ": " +
                puntosLocal + " - " +
                equipoVisitante.toString() + ": " + puntosVisitante;
    }

}




