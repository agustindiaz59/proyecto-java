package ar.utn;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);

        //Solicito que ingrese los datos de los archivos
        System.out.println("Escriba la direccion del archivo de pronosticos:");
        Path pron = Paths.get(teclado.next());
        System.out.println("Escriba la direccion del archivo de resultados:");
        Path result = Paths.get(teclado.next());

        //Confirmo que los archivos existan
        if(!Files.exists(pron)){
            System.out.println("El archivo de pronosticos no existe");
            System.exit(0);
        } else if (!Files.exists(result)) {
            System.out.println("El archivo de resultados no existe");
            System.exit(0);
        }else {
            System.out.println("Perfecto, seguimos");
        }

        //Configuro el Scanner para los archivos
        Scanner pronosticos = new Scanner(pron);
        Scanner resultados = new Scanner(result);
        pronosticos.useDelimiter("[;\\n\\r]+");
        resultados.useDelimiter("[;\\n\\r]+");

        //Declaro la lista de Partidos con sus resultados y de predicciones o pronosticos
        ArrayList<Partido> partidos = new ArrayList<>();
        ArrayList<String> apuesta = new ArrayList<>();

        //Cargo la lista de resultados
        while(resultados.hasNext()){
            String local = resultados.next();
            int puntosLocal = resultados.nextInt();
            int puntosVisitante = resultados.nextInt();
            String visitante = resultados.next();

            partidos.add(new Partido(new Equipo(local),puntosLocal,puntosVisitante,new Equipo(visitante)));
        }

        //Cargo la lista de predicciones
        for (Partido p :partidos){
            System.out.println("Quien crees que gane?");
            System.out.println(p.getEquipoLocal()+" o "+p.getEquipoVisitante());
            String ganador = teclado.next();
            System.out.println(p.resultado(new Equipo(ganador)));
        }
        System.out.println(apuesta);
    }
}
