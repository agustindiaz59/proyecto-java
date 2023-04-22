package ar.utn;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
@NoArgsConstructor@Getter@Setter
public class Ronda {
    private ArrayList<Partido> partidos = new ArrayList<>();
    public void agregarPartido(Partido p){
        this.partidos.add(p);
    }
    public String buscarPartido(int numeroPartido){
        String resultado = null;
        for (Partido par:this.partidos){
            if (par.getNumeroPartido() == numeroPartido){
                resultado = par.resultado();
                return resultado;
            }
        }
        System.out.println(resultado);
        return resultado;
    }
}
