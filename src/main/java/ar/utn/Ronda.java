package ar.utn;

import lombok.Getter;
import lombok.Setter;

import java.sql.SQLException;
import java.util.ArrayList;
@Getter@Setter
public class Ronda {
    private ArrayList<Partido> partidos = new ArrayList<>();
    public Ronda() throws SQLException {
        Lector lector = new Lector();
        partidos.addAll(lector.leerPartidosBD());
    }
    public void agregarPartido(Partido p){
        this.partidos.add(p);
    }
}
