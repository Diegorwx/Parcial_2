package co.edu.uniquindio.poo.Punto3;

import co.edu.uniquindio.poo.Estructuras.Cola;

public class Pendientes {

    public static Cola<Solicitud> seleccionarSolicitudes(Cola<Solicitud> pendientes, int minutos) {
        Cola<Solicitud> seleccionadas = new Cola<>();
        if (pendientes == null || minutos <= 0) {
            return seleccionadas;
        }

        int restante = minutos;
        restante = pasada(pendientes, seleccionadas, Prioridad.ALTA, restante);
        restante = pasada(pendientes, seleccionadas, Prioridad.NORMAL, restante);

        return seleccionadas;
    }

    private static int pasada(Cola<Solicitud> pendientes, Cola<Solicitud> seleccionadas,
                              Prioridad prioridad, int restante) {
        int n = pendientes.getSize();

        for (int i = 0; i < n; i++) {
            Solicitud s = pendientes.desencolar();

            if (s.getPrioridad() == prioridad && s.getDuracion() <= restante) {
                seleccionadas.encolar(s);
                restante -= s.getDuracion();
            } else {
                pendientes.encolar(s);
            }
        }
        return restante;
    }
}
