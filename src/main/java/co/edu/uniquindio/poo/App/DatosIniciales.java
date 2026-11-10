package co.edu.uniquindio.poo.App;

import co.edu.uniquindio.poo.Estructuras.*;
import co.edu.uniquindio.poo.Punto1y2.*;
import co.edu.uniquindio.poo.Punto3.*;
import co.edu.uniquindio.poo.Punto4.*;


public class DatosIniciales {

    public static void cargar(Stack<Operacion> historial,
                              Stack<String> acciones,
                              Cola<Solicitud> pendientes,
                              ArbolBinario<Integer> equipos) {
        // Ejercicio 1 (O5 queda en el tope)
        historial.push(new Operacion("O1", Estado.ANULADA));
        historial.push(new Operacion("O2", Estado.CONFIRMADA));
        historial.push(new Operacion("O3", Estado.CONFIRMADA));
        historial.push(new Operacion("O4", Estado.ANULADA));
        historial.push(new Operacion("O5", Estado.CONFIRMADA));

        // Ejercicio 2 (A6 queda en el tope)
        for (int i = 1; i <= 6; i++) {
            acciones.push("A" + i);
        }

        // Ejercicio 3
        pendientes.encolar(new Solicitud("S1", Prioridad.NORMAL, 10));
        pendientes.encolar(new Solicitud("S2", Prioridad.ALTA, 30));
        pendientes.encolar(new Solicitud("S3", Prioridad.ALTA, 15));
        pendientes.encolar(new Solicitud("S4", Prioridad.NORMAL, 5));

        // Ejercicio 4
        int[] codigos = {50, 30, 70, 20, 40, 60, 80, 55, 65};
        for (int c : codigos) {
            equipos.insertar(c);
        }
    }
}
