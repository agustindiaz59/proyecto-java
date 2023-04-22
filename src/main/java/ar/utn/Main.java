package ar.utn;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        //Defino cuanto vale cada acierto
        Scanner teclado = new Scanner(System.in);
        System.out.println("Cuantos puntos vale cada acierto?");
        final int puntos = teclado.nextInt();
        teclado.close();

        //Traigo los datos con el lector y construyo los datos del programa asignandole los valores
        Lector lector = new Lector();

        Ronda ronda = new Ronda();
        for (Partido p : lector.leerPartidosBD()) {
            ronda.agregarPartido(p);
        }

        Prode campeonato = new Prode(ronda);
        for (Pronostico pro : lector.leerPronosticosBD()) {
            if (!campeonato.existeJugador(pro.getJugador())) {
                campeonato.agregarJugador(pro.getJugador());
                campeonato.getJugadores().get(pro.getJugador().getNombre()).agregarPronostico(pro);
            } else {
                campeonato.getJugadores().get(pro.getJugador().getNombre()).agregarPronostico(pro);
            }
        }

        //Calculo los puntos de cada jugador
        campeonato.calcularPuntos(puntos);

        //Imprimo por pantalla
        for (String j : campeonato.getJugadoresId()) {
            System.out.println(campeonato.getJugadores().get(j).toString());
        }
        System.out.println("Felicidades, el ganador es: " + campeonato.ganador().getNombre());
    }
}