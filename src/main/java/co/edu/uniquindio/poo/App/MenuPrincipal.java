package co.edu.uniquindio.poo.App;

import co.edu.uniquindio.poo.Estructuras.*;
import co.edu.uniquindio.poo.Punto1y2.*;
import co.edu.uniquindio.poo.Punto3.*;
import co.edu.uniquindio.poo.Punto4.*;

import java.util.Scanner;

public class MenuPrincipal {

    // Estructuras de trabajo (una por ejercicio)
    private final Stack<Operacion> historial = new Stack<>();     // Ejercicio 1
    private final Stack<String> acciones = new Stack<>();         // Ejercicio 2
    private final Cola<Solicitud> pendientes = new Cola<>();      // Ejercicio 3
    private final ArbolBinario<Integer> equipos = new ArbolBinario<>(); // Ejercicio 4

    private final Scanner entrada = new Scanner(System.in);

    public void ejecutar() {
        boolean activo = true;
        while (activo) {
            mostrarMenu();
            String opcion = leerTexto("Elija una opcion: ");
            try {
                switch (opcion) {
                    case "1" -> registrarOperacion();
                    case "2" -> mostrarHistorial();
                    case "3" -> ultimasConfirmadas();
                    case "4" -> registrarAccion();
                    case "5" -> mostrarAcciones();
                    case "6" -> segmentoAcciones();
                    case "7" -> registrarSolicitud();
                    case "8" -> mostrarPendientes();
                    case "9" -> seleccionarSolicitudes();
                    case "10" -> insertarEquipo();
                    case "11" -> mostrarEquipos();
                    case "12" -> contarEnRango();
                    case "13" -> cargarDatosEjemplo();
                    case "14" -> limpiarTodo();
                    case "0" -> activo = false;
                    default -> System.out.println("Opcion no valida.");
                }
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println();
        }
        System.out.println("Hasta luego.");
    }

    private void mostrarMenu() {
        System.out.println("\n=== PARCIAL 2 - ESTRUCTURA DE DATOS ===");
        System.out.println("--- Ejercicio 1: Historial (Pila) ---");
        System.out.println(" 1) Registrar operacion");
        System.out.println(" 2) Ver historial");
        System.out.println(" 3) Obtener ultimas N confirmadas");
        System.out.println("--- Ejercicio 2: Segmento de pila ---");
        System.out.println(" 4) Apilar accion");
        System.out.println(" 5) Ver pila de acciones");
        System.out.println(" 6) Obtener segmento [inicio, fin]");
        System.out.println("--- Ejercicio 3: Soporte (Cola) ---");
        System.out.println(" 7) Registrar solicitud");
        System.out.println(" 8) Ver solicitudes pendientes");
        System.out.println(" 9) Seleccionar solicitudes por minutos");
        System.out.println("--- Ejercicio 4: Laboratorio (ABB) ---");
        System.out.println("10) Insertar equipo");
        System.out.println("11) Ver equipos (inorden)");
        System.out.println("12) Contar equipos en rango");
        System.out.println("--- General ---");
        System.out.println("13) Cargar datos de ejemplo");
        System.out.println("14) Limpiar todo");
        System.out.println(" 0) Salir");
    }

    // ================= EJERCICIO 1 =================

    private void registrarOperacion() {
        String codigo = leerTexto("Codigo: ");
        String e = leerTexto("Estado (C = confirmada, A = anulada): ").toUpperCase();
        Estado estado = switch (e) {
            case "C" -> Estado.CONFIRMADA;
            case "A" -> Estado.ANULADA;
            default -> throw new IllegalArgumentException("Estado no valido (use C o A)");
        };
        historial.push(new Operacion(codigo, estado));
        System.out.println("Operacion registrada.");
    }

    private void mostrarHistorial() {
        System.out.println("Historial (tope primero):");
        if (historial.isEmpty()) {
            System.out.println("  (vacio)");
        } else {
            historial.print();
        }
        System.out.println("size = " + historial.getSize());
    }

    private void ultimasConfirmadas() {
        int n = leerEntero("N: ");
        Stack<Operacion> resultado = Historial.obtenerUltimasConfirmadas(historial, n);
        System.out.println("Resultado (tope primero):");
        if (resultado.isEmpty()) {
            System.out.println("  (vacio)");
        } else {
            resultado.print();
        }
        System.out.println("El historial original conserva " + historial.getSize() + " operaciones.");
    }

    // ================= EJERCICIO 2 =================

    private void registrarAccion() {
        String accion = leerTexto("Accion: ");
        if (accion.isEmpty()) {
            throw new IllegalArgumentException("La accion no puede estar vacia");
        }
        acciones.push(accion);
        System.out.println("Accion apilada.");
    }

    private void mostrarAcciones() {
        System.out.println("Pila de acciones (tope primero):");
        if (acciones.isEmpty()) {
            System.out.println("  (vacia)");
        } else {
            acciones.print();
        }
        System.out.println("size = " + acciones.getSize());
    }

    private void segmentoAcciones() {
        int inicio = leerEntero("Inicio (1 = tope): ");
        int fin = leerEntero("Fin: ");
        Stack<String> segmento = Historial.obtenerSegmento(acciones, inicio, fin);
        System.out.println("Segmento (tope primero):");
        if (segmento.isEmpty()) {
            System.out.println("  (vacio: rango invalido)");
        } else {
            segmento.print();
        }
        System.out.println("La pila original conserva " + acciones.getSize() + " acciones.");
    }

    // ================= EJERCICIO 3 =================

    private void registrarSolicitud() {
        String codigo = leerTexto("Codigo: ");
        String p = leerTexto("Prioridad (A = alta, N = normal): ").toUpperCase();
        Prioridad prioridad = switch (p) {
            case "A" -> Prioridad.ALTA;
            case "N" -> Prioridad.NORMAL;
            default -> throw new IllegalArgumentException("Prioridad no valida (use A o N)");
        };
        int duracion = leerEntero("Duracion (min): ");
        pendientes.encolar(new Solicitud(codigo, prioridad, duracion));
        System.out.println("Solicitud registrada.");
    }

    private void mostrarPendientes() {
        mostrarCola("Solicitudes pendientes (de primera a ultima):", pendientes);
    }

    private void seleccionarSolicitudes() {
        int minutos = leerEntero("Minutos disponibles: ");
        Cola<Solicitud> seleccionadas = Pendientes.seleccionarSolicitudes(pendientes, minutos);
        mostrarCola("Seleccionadas (orden de atencion):", seleccionadas);
        mostrarCola("Pendientes restantes:", pendientes);
    }

    // ================= EJERCICIO 4 =================

    private void insertarEquipo() {
        int codigo = leerEntero("Codigo del equipo: ");
        equipos.insertar(codigo);
        System.out.println("Equipo insertado.");
    }

    private void mostrarEquipos() {
        if (equipos.isEmpty()) {
            System.out.println("No hay equipos registrados.");
            return;
        }
        System.out.println("Equipos en inorden (ascendente):");
        equipos.recorrerInorden();
    }

    private void contarEnRango() {
        int inferior = leerEntero("Limite inferior: ");
        int superior = leerEntero("Limite superior: ");
        int total = Equipos.contarEquiposEnRango(equipos.getRaiz(), inferior, superior);
        System.out.println("Equipos con codigo en [" + inferior + ", " + superior + "]: " + total);
    }

    // ================= GENERAL =================

    private void cargarDatosEjemplo() {
        limpiarTodo();
        DatosIniciales.cargar(historial, acciones, pendientes, equipos);
        System.out.println("Datos de ejemplo cargados en los 4 ejercicios.");
    }

    private void limpiarTodo() {
        while (!historial.isEmpty()) historial.pop();
        while (!acciones.isEmpty()) acciones.pop();
        while (!pendientes.isEmpty()) pendientes.desencolar();
        equipos.setRaiz(null);
        equipos.setPeso(0);
    }

    // ================= UTILIDADES =================

    // Imprime una cola SIN perderla (vuelta completa)
    private void mostrarCola(String etiqueta, Cola<Solicitud> cola) {
        System.out.println(etiqueta);
        int n = cola.getSize();
        for (int i = 0; i < n; i++) {
            Solicitud s = cola.desencolar();
            System.out.println("  " + s);
            cola.encolar(s);
        }
        if (n == 0) {
            System.out.println("  (vacia)");
        }
    }

    private String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return entrada.nextLine().trim();
    }

    private int leerEntero(String mensaje) {
        while (true) {
            try {
                return Integer.parseInt(leerTexto(mensaje));
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero entero.");
            }
        }
    }
}