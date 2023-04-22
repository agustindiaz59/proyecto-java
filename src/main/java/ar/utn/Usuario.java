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
    public ArrayList<Integer> numerosPronosticos(){
        ArrayList<Integer> numeros = new ArrayList<>();
        for (Pronostico pro : this.pronosticos){
            numeros.add(pro.getNumeroPartido());
        }
        return numeros;
    }
    public Pronostico buscarPronostico(int numeroPartido){
        Pronostico buscado = null;
        for (Pronostico pro: this.pronosticos){
            if(pro.getNumeroPartido() == numeroPartido){
                buscado = pro;
                break;
            }
        }
        return buscado;
    }
    public int calcularAciertos(Ronda r){
        for (Pronostico pro: pronosticos) {
            int numPartido = pro.getNumeroPartido();
            String aComparar = r.buscarPartido(numPartido);
            if(pro.getResultado().equals(aComparar)){
                this.aciertos ++;
            }
        }
        return this.aciertos;
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
