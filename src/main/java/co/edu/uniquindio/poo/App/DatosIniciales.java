package co.edu.uniquindio.poo.App;

import co.edu.uniquindio.poo.Estructuras.ArbolBinario;
import co.edu.uniquindio.poo.Estructuras.Cola;
import co.edu.uniquindio.poo.Estructuras.Stack;
import co.edu.uniquindio.poo.Punto1y2.Estado;
import co.edu.uniquindio.poo.Punto1y2.Operacion;
import co.edu.uniquindio.poo.Punto3.Prioridad;
import co.edu.uniquindio.poo.Punto3.Solicitud;

public class DatosIniciales {

    // Ejercicio 1
    public static Stack<Operacion> historial() {
        Stack<Operacion> pila = new Stack<>();
        pila.push(new Operacion("O1", Estado.ANULADA));
        pila.push(new Operacion("O2", Estado.CONFIRMADA));
        pila.push(new Operacion("O3", Estado.CONFIRMADA));
        pila.push(new Operacion("O4", Estado.ANULADA));
        pila.push(new Operacion("O5", Estado.CONFIRMADA));
        return pila;
    }

    // Ejercicio 2
    public static Stack<String> acciones() {
        Stack<String> pila = new Stack<>();
        for (int i = 1; i <= 6; i++) {
            pila.push("A" + i);
        }
        return pila;
    }

    // Ejercicio 3
    public static Cola<Solicitud> solicitudes() {
        Cola<Solicitud> cola = new Cola<>();
        cola.encolar(new Solicitud("S1", Prioridad.NORMAL, 10));
        cola.encolar(new Solicitud("S2", Prioridad.ALTA, 30));
        cola.encolar(new Solicitud("S3", Prioridad.ALTA, 15));
        cola.encolar(new Solicitud("S4", Prioridad.NORMAL, 5));
        return cola;
    }

    // Ejercicio 4
    public static ArbolBinario<Integer> equipos() {
        ArbolBinario<Integer> arbol = new ArbolBinario<>();
        int[] codigos = {50, 30, 70, 20, 40, 60, 80, 55, 65};
        for (int codigo : codigos) {
            arbol.insertar(codigo);
        }
        return arbol;
    }
}