package co.edu.uniquindio.poo;

public class Main {

    public static void main(String[] args) {

        // Ejercicio 1
        Stack<Operacion> historial = new Stack<>();
        historial.push(new Operacion("O1", Estado.ANULADA));
        historial.push(new Operacion("O2", Estado.CONFIRMADA));
        historial.push(new Operacion("O3", Estado.CONFIRMADA));
        historial.push(new Operacion("O4", Estado.ANULADA));
        historial.push(new Operacion("O5", Estado.CONFIRMADA));

        System.out.println("* EJERCICIO 1");
        System.out.println("Historial original:");
        historial.print();

        System.out.println("\nn = 2 (esperado: O5, O3):");
        Historial.obtenerUltimasConfirmadas(historial, 2).print();

        System.out.println("\nn = 10 (esperado: O5, O3, O2):");
        Historial.obtenerUltimasConfirmadas(historial, 10).print();

        System.out.println("\nn = 0 (esperado: vacia):");
        Historial.obtenerUltimasConfirmadas(historial, 0).print();

        System.out.println("\nHistorial despues (esperado: igual al original, size 5):");
        historial.print();
        System.out.println("size = " + historial.getSize());

        // Ejercicio 2
        Stack<String> acciones = new Stack<>();
        for (int i = 1; i <= 6; i++) {
            acciones.push("A" + i);
        }

        System.out.println("\n* EJERCICIO 2");
        System.out.println("Pila original:");
        acciones.print();

        System.out.println("\ninicio = 2, fin = 4 (esperado: A5, A4, A3):");
        Historial.obtenerSegmento(acciones, 2, 4).print();

        System.out.println("\ninicio = 3, fin = 3 (esperado: A4):");
        Historial.obtenerSegmento(acciones, 3, 3).print();

        System.out.println("\ninicio = 4, fin = 2 (esperado: vacia):");
        Historial.obtenerSegmento(acciones, 4, 2).print();

        System.out.println("\ninicio = 2, fin = 7 (esperado: vacia):");
        Historial.obtenerSegmento(acciones, 2, 7).print();

        acciones.print();
        System.out.println("Tamaño de la pila = " + acciones.getSize());
    }
}
