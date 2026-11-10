package co.edu.uniquindio.poo.Punto4;

import co.edu.uniquindio.poo.Estructuras.NodeArbol;

public class Equipos {

    public static int contarEquiposEnRango(NodeArbol<Integer> nodo, int inferior, int superior) {
        if (nodo == null || inferior > superior) {
            return 0;
        }

        int codigo = nodo.getElemento();

        if (codigo < inferior) {
            return contarEquiposEnRango(nodo.getDerecho(), inferior, superior);
        }
        if (codigo > superior) {
            return contarEquiposEnRango(nodo.getIzquierdo(), inferior, superior);
        }

        return 1 + contarEquiposEnRango(nodo.getIzquierdo(), inferior, superior)
                + contarEquiposEnRango(nodo.getDerecho(), inferior, superior);
    }
}
