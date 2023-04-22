package ar.utn;

import lombok.NoArgsConstructor;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
@NoArgsConstructor
public class Lector {
    public ArrayList<Partido> leerPartidosTXT() throws IOException {
        ArrayList<Partido> listaPartidos = new ArrayList<>();

        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese la direccion del archivo de partidos");
        Path archivoPartidos = Paths.get(teclado.next());
        teclado.close();

        Scanner scannerPartidos = new Scanner(archivoPartidos);
        scannerPartidos.useDelimiter("[,;\n\r ]+");
        while (scannerPartidos.hasNext()){
            Equipo local = new Equipo(scannerPartidos.next());
            int puntosLocal = scannerPartidos.nextInt();
            int puntosVisitante = scannerPartidos.nextInt();
            Equipo visitante = new Equipo(scannerPartidos.next());
            int numeroPartido = scannerPartidos.nextInt();
            Partido p = new Partido(local,puntosLocal,puntosVisitante,visitante,numeroPartido);
            listaPartidos.add(p);
        }
        scannerPartidos.close();
        return listaPartidos;
    }
    public ArrayList<Pronostico> leerPronosticosTXT() throws IOException {
        ArrayList<Pronostico> listaPronosticos = new ArrayList<>();

        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese la direccion del archivo de pronosticos");
        Path archivoPronosticos = Paths.get(teclado.next());
        teclado.close();

        Scanner scannerPronosticos = new Scanner(archivoPronosticos);
        scannerPronosticos.useDelimiter("[,;\n\r ]+");
        while (scannerPronosticos.hasNext()){
            Usuario jugador = new Usuario(scannerPronosticos.next());
            Equipo local = new Equipo(scannerPronosticos.next());
            String resultado = scannerPronosticos.next();
            Equipo visitante = new Equipo(scannerPronosticos.next());
            int numeroPartido = scannerPronosticos.nextInt();
            Pronostico pro = new Pronostico(local,visitante,resultado,jugador,numeroPartido);
            listaPronosticos.add(pro);
        }
        scannerPronosticos.close();
        return listaPronosticos;
    }
    public ArrayList<Partido> leerPartidosBD() throws SQLException {
        Connection tp = DriverManager.getConnection("jdbc:mysql://localhost:3306/tp-java","root","");
        Statement st = tp.createStatement();
        ResultSet registro;
        ArrayList<Partido> listaPartidos = new ArrayList<>();

        registro = st.executeQuery("select * from resultados");
        while (registro.next()) {
            String local = registro.getString("local");
            int puntosLocal = registro.getInt("puntosLocal");
            int puntosVisitante = registro.getInt("puntosVisitante");
            String visitante = registro.getString("visitante");
            int numeroPartido = registro.getInt("partido");
            Partido p = new Partido(new Equipo(local), puntosLocal, puntosVisitante, new Equipo(visitante),numeroPartido);
            listaPartidos.add(p);
        }
        tp.close();
        return listaPartidos;
    }
    public ArrayList<Pronostico> leerPronosticosBD() throws SQLException {
        Connection tp = DriverManager.getConnection("jdbc:mysql://localhost:3306/tp-java","root","");
        Statement st = tp.createStatement();
        ResultSet registro;
        ArrayList<Pronostico> listaPronosticos = new ArrayList<>();

        registro = st.executeQuery("select * from pronosticos");
        while (registro.next()) {
            Equipo local = new Equipo(registro.getString("local"));
            String resultado = registro.getString("resultado");
            Equipo visitante = new Equipo(registro.getString("visitante"));
            Usuario jugador = new Usuario(registro.getString("participante"));
            int numeroPartido = registro.getInt("partido");
            Pronostico pro = new Pronostico(local,visitante,resultado,jugador,numeroPartido);
            listaPronosticos.add(pro);
        }
        tp.close();
        return listaPronosticos;
    }
}
