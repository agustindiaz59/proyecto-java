package ar.utn;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter@Setter
public class Usuario {
    private String nombre;
    private int aciertos = 0;
    private int puntaje = 0;
    private ArrayList<Pronostico> pronosticos = new ArrayList<>();

    public Usuario(String nombre) {
        this.nombre = nombre;
    }
    public void agregarPronostico(Pronostico pro){
        this.pronosticos.add(pro);
    }
    public void calcularAciertos(Ronda r){
        for (Pronostico pro: pronosticos) {
            int proNumPartido = pro.getNumeroPartido();

            for (Partido p:r.getPartidos()) {
                int parNumPartido = p.getNumeroPartido();
                boolean mismoPartido = proNumPartido == parNumPartido;
                boolean mismosEquipos =
                        (p.getEquipoLocal().getNombre().equals(pro.getLocal().getNombre()) && p.getEquipoVisitante().getNombre().equals(pro.getVisitante().getNombre()))
                        || (p.getEquipoLocal().getNombre().equals(pro.getVisitante().getNombre()) && p.getEquipoVisitante().getNombre().equals(pro.getLocal().getNombre()));
                boolean ganadorCorrecto = p.resultado().equals(pro.getResultado());

                //Tienen que coincidir los equipos sin importar el orden, el resultado y el numero de partido
                if(mismoPartido && mismosEquipos && ganadorCorrecto){
                    this.aciertos++;
                }
            }
        }
    }
    public void sumarPuntaje(int puntaje){
        for(int i = 0; i < this.aciertos;i++){
            this.puntaje += puntaje;
        }
    }
    public String toString() {

        return "Nombre de usuario: " + this.nombre + "\n\r" +
                "Puntaje: "+ this.puntaje + "\n\r"+
                "Aciertos: "+ this.aciertos+ "\n\r"+
                "Pronosticos: " + this.pronosticos+"\n\r";
    }

}
