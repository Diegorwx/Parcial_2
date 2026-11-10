package co.edu.uniquindio.poo.App;

import co.edu.uniquindio.poo.Estructuras.ArbolBinario;
import co.edu.uniquindio.poo.Estructuras.Cola;
import co.edu.uniquindio.poo.Estructuras.Stack;
import co.edu.uniquindio.poo.Punto1y2.Historial;
import co.edu.uniquindio.poo.Punto1y2.Operacion;
import co.edu.uniquindio.poo.Punto3.Pendientes;
import co.edu.uniquindio.poo.Punto3.Solicitud;
import co.edu.uniquindio.poo.Punto4.Equipos;

import java.util.Scanner;

public class MenuPrincipal {

    private Stack<Operacion> historial;
    private Stack<String> acciones;
    private Cola<Solicitud> pendientes;
    private ArbolBinario<Integer> equipos;

    private final Scanner entrada = new Scanner(System.in);

    public MenuPrincipal() {
        restaurarDatos();
    }

    public void ejecutar() {
        boolean activo = true;
        while (activo) {
            mostrarMenu();
            try {
                switch (leerEntero("Opcion: ")) {
                    case 1 -> verHistorial();
                    case 2 -> ultimasConfirmadas();
                    case 3 -> verAcciones();
                    case 4 -> segmento();
                    case 5 -> verPendientes();
                    case 6 -> seleccionarSolicitudes();
                    case 7 -> verEquipos();
                    case 8 -> contarEnRango();
                    case 9 -> restaurarDatos();
                    case 0 -> activo = false;
                    default -> System.out.println("Opcion no valida.");
                }
            } catch (RuntimeException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        System.out.println("Hasta luego.");
    }

    private void mostrarMenu() {
        System.out.println("1) Ver historial                  (Ej. 1)");
        System.out.println("2) Ultimas N confirmadas          (Ej. 1)");
        System.out.println("3) Ver pila de acciones           (Ej. 2)");
        System.out.println("4) Segmento [inicio, fin]         (Ej. 2)");
        System.out.println("5) Ver solicitudes pendientes     (Ej. 3)");
        System.out.println("6) Seleccionar por minutos        (Ej. 3)");
        System.out.println("7) Ver equipos                    (Ej. 4)");
        System.out.println("8) Contar equipos en rango        (Ej. 4)");
        System.out.println("9) Restaurar datos iniciales");
        System.out.println("0) Salir");
    }

    // Ejercicio 1

    private void verHistorial() {
        System.out.println("Historial:");
        historial.print();
    }

    private void ultimasConfirmadas() {
        int n = leerEntero("N: ");
        System.out.println("Resultado:");
        Historial.obtenerUltimasConfirmadas(historial, n).print();
    }

    // Ejercicio 2

    private void verAcciones() {
        System.out.println("Acciones:");
        acciones.print();
    }

    private void segmento() {
        int inicio = leerEntero("Inicio (1 = tope): ");
        int fin = leerEntero("Fin: ");
        System.out.println("Segmento (vacio si el rango no es valido):");
        Historial.obtenerSegmento(acciones, inicio, fin).print();
    }

    // Ejercicio 3

    private void verPendientes() {
        System.out.println("Pendientes (de primera a ultima):");
        pendientes.print();
    }

    private void seleccionarSolicitudes() {
        int minutos = leerEntero("Minutos disponibles: ");
        Cola<Solicitud> seleccionadas = Pendientes.seleccionarSolicitudes(pendientes, minutos);
        System.out.println("Seleccionadas:");
        seleccionadas.print();
        System.out.println("Pendientes restantes:");
        pendientes.print();
    }

    // Ejercicio 4

    private void verEquipos() {
        System.out.print("Inorden:   ");
        equipos.recorrerInorden();
        System.out.print("\nAmplitud:  ");
        equipos.recorridoAmplitud();
        System.out.println();
    }

    private void contarEnRango() {
        int inferior = leerEntero("Limite inferior: ");
        int superior = leerEntero("Limite superior: ");
        int total = Equipos.contarEquiposEnRango(equipos.getRaiz(), inferior, superior);
        System.out.println("Equipos en [" + inferior + ", " + superior + "]: " + total);
    }

    // Datos

    private void restaurarDatos() {
        historial = DatosIniciales.historial();
        acciones = DatosIniciales.acciones();
        pendientes = DatosIniciales.solicitudes();
        equipos = DatosIniciales.equipos();
    }

    private int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(entrada.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero entero.");
            }
        }
    }
}