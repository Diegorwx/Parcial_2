package co.edu.uniquindio.poo.Punto1y2;

import co.edu.uniquindio.poo.Estructuras.Stack;

public class Historial {

    public static Stack<Operacion> obtenerUltimasConfirmadas(Stack<Operacion> historial, int n) {
        Stack<Operacion> resultado = new Stack<>();
        if (historial == null || n <= 0) {
            return resultado;
        }

        Stack<Operacion> aux = new Stack<>();
        Stack<Operacion> invertida = new Stack<>();
        int encontradas = 0;

        while (!historial.isEmpty() && encontradas < n) {
            Operacion op = historial.pop();
            aux.push(op);
            if (op.getEstado() == Estado.CONFIRMADA) {
                invertida.push(op);
                encontradas++;
            }
        }

        while (!aux.isEmpty()) {
            historial.push(aux.pop());
        }
        while (!invertida.isEmpty()) {
            resultado.push(invertida.pop());
        }
        return resultado;
    }

    public static <T> Stack<T> obtenerSegmento(Stack<T> pila, int inicio, int fin) {
        Stack<T> resultado = new Stack<>();
        if (pila == null || inicio < 1 || inicio > fin || fin > pila.getSize()) {
            return resultado;
        }

        Stack<T> aux = new Stack<>();
        Stack<T> invertida = new Stack<>();

        for (int pos = 1; pos <= fin; pos++) {
            T dato = pila.pop();
            aux.push(dato);
            if (pos >= inicio) {
                invertida.push(dato);
            }
        }

        while (!aux.isEmpty()) {
            pila.push(aux.pop());
            while (!invertida.isEmpty()) {
                resultado.push(invertida.pop());
            }
        }

        return resultado;
    }
}
