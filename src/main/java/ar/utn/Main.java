package ar.utn;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        Scanner teclado = new Scanner(System.in);

        //Solicito que ingrese los datos de los archivos
        System.out.println("Escriba la direccion del archivo de pronosticos:");
        Path pron = Paths.get(teclado.next());
        System.out.println("Escriba la direccion del archivo de resultados:");
        Path result = Paths.get(teclado.next());
        //
        System.out.println("Ingrese su nombre de usuario");
        Usuario jugador = new Usuario(teclado.next());
        System.out.println("Cuantos puntos vale cada acierto?");
        int puntos = teclado.nextInt();

        //Confirmo que los archivos existan
        if (!Files.exists(pron)) {
            System.out.println("El archivo de pronosticos no existe");
            System.exit(0);
        } else if (!Files.exists(result)) {
            System.out.println("El archivo de resultados no existe");
            System.exit(0);
        } else {
            System.out.println("Perfecto, seguimos");
        }

        //Configuro el Scanner para los archivos
        Scanner pronosticos = new Scanner(pron);
        Scanner resultados = new Scanner(result);
        pronosticos.useDelimiter("[;\\n\\r]+");
        resultados.useDelimiter("[;\\n\\r]+");

        //Declaro la lista de Partidos con sus resultados y de predicciones o pronosticos
        ArrayList<Partido> partidos = new ArrayList<>();
        ArrayList<Pronostico> apuesta = new ArrayList<>();

        //Cargo la lista de pronoticos
        while (pronosticos.hasNext()) {
            String local = pronosticos.next();
            int puntosLocal = pronosticos.nextInt();
            int puntosVisitante = pronosticos.nextInt();
            String visitante = pronosticos.next();
            Partido p = new Partido(new Equipo(local), puntosLocal, puntosVisitante, new Equipo(visitante));

            apuesta.add(new Pronostico(p));
        }

        //Cargo la lista de resultados
        while (resultados.hasNext()) {
            String local = resultados.next();
            int puntosLocal = resultados.nextInt();
            int puntosVisitante = resultados.nextInt();
            String visitante = resultados.next();

            partidos.add(new Partido(new Equipo(local), puntosLocal, puntosVisitante, new Equipo(visitante)));
        }

        //Sumar puntaje por cada prediccion

        for(int i = 0; i < apuesta.size(); i++){
            //Sacar de la apuesta los nombres de los dos equipos
            //Buscar en la lista de partidos el partido de esos dos equipos
        if (apuesta.get(i).getPartido().resultado().equals(partidos.get(i).resultado())){
            jugador.sumarPuntaje(puntos);
            }}
        System.out.println(jugador.toString());
        }
}