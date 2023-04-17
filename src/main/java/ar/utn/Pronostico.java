package ar.utn;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @AllArgsConstructor @Setter
public class Pronostico {
    Partido partido;

    @Override
    public String toString() {
        return partido.toString();
    }
}
