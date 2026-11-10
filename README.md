# Parcial II – Estructuras de Datos

Universidad del Quindío · Ingeniería de Sistemas y Computación · Estructuras de Datos

**Integrantes:** Diego Alejandro Florez Serna · Yesuu Esteban Aros Tique

## Descripción

Solución en Java de los ejercicios 1 a 4 del Parcial II, usando únicamente las estructuras propias del curso (`Stack`, `Cola` y `ArbolBinario`), sin colecciones de `java.util`.

Un menú por consola permite ver los datos de cada ejercicio y ejecutar el método correspondiente. El programa arranca con los datos del enunciado ya cargados, pero no los imprime hasta que se elige una opción de "Ver".

El ejercicio 5 (ABB y AVL con rotaciones y factor de equilibrio) y el dibujo del ejercicio 4b se resuelven en el documento de soluciones, no en código.

## Ejercicios

| # | Clase | Método | Estructura propia |
|---|-------|--------|-------------------|
| 1 | `Historial` | `obtenerUltimasConfirmadas(historial, n)` | `Stack` |
| 2 | `Historial` | `obtenerSegmento(pila, inicio, fin)` | `Stack` |
| 3 | `Pendientes` | `seleccionarSolicitudes(pendientes, minutos)` | `Cola` |
| 4a | `Equipos` | `contarEquiposEnRango(nodo, inferior, superior)` | `ArbolBinario` (ABB) |

## Estructura del proyecto

```
src/main/java/co/edu/uniquindio/poo/
├── App/
│   ├── Main.java             punto de entrada: solo ejecuta el menú
│   ├── MenuPrincipal.java    menú por consola
│   └── DatosIniciales.java   datos del enunciado de cada ejercicio como ejemplo
├── Estructuras/
│   ├── Stack.java, Node.java
│   ├── Cola.java, NodeSimple.java
│   └── ArbolBinario.java, NodeArbol.java
├── Punto1y2/
│   ├── Historial.java
│   ├── Operacion.java
│   └── Estado.java
├── Punto3/
│   ├── Pendientes.java
│   ├── Solicitud.java
│   └── Prioridad.java
└── Punto4/
    └── Equipos.java
```

## Requisitos

- JDK 25 (versión configurada en `pom.xml`).
- Maven, si se quiere compilar con `mvn`.

## Cómo ejecutar

Desde el IDE: ejecutar `co.edu.uniquindio.poo.App.Main`.

Desde la terminal, en la carpeta raíz del proyecto:

```bash
javac -d out $(find src -name "*.java")
java -cp out co.edu.uniquindio.poo.App.Main
```

## Menú

| Opción | Ejercicio | Acción |
|--------|-----------|--------|
| 1 | 1 | Ver el historial de operaciones |
| 2 | 1 | Obtener las últimas N operaciones confirmadas |
| 3 | 2 | Ver la pila de acciones |
| 4 | 2 | Obtener el segmento `[inicio, fin]` |
| 5 | 3 | Ver las solicitudes pendientes |
| 6 | 3 | Seleccionar solicitudes según los minutos disponibles |
| 7 | 4 | Ver los equipos (recorrido inorden y en amplitud) |
| 8 | 4 | Contar los equipos dentro de un rango |
| 9 | — | Restaurar los datos iniciales |
| 0 | — | Salir |

La opción 9 es necesaria porque el ejercicio 3 retira de la cola las solicitudes seleccionadas.

## Datos iniciales

Definidos en `DatosIniciales`, que construye cada estructura sin imprimir nada.

| Ejercicio | Datos |
|-----------|-------|
| 1 | O1 anulada, O2 confirmada, O3 confirmada, O4 anulada, O5 confirmada (tope) |
| 2 | A1 a A6 (A6 en el tope) |
| 3 | S1 normal 10 min, S2 alta 30 min, S3 alta 15 min, S4 normal 5 min |
| 4 | 50, 30, 70, 20, 40, 60, 80, 55, 65 (en ese orden) |

## Resultados esperados

| Ejercicio | Entrada | Resultado |
|-----------|---------|-----------|
| 1 | `n = 2` | O5 (tope), O3 |
| 1 | `n = 10` | O5, O3, O2 |
| 1 | `n = 0` | Pila vacía |
| 2 | `inicio = 2`, `fin = 4` | A5, A4, A3 |
| 2 | `inicio = 3`, `fin = 3` | A4 |
| 2 | `inicio = 4`, `fin = 2` o `fin = 7` | Pila vacía |
| 3 | 25 minutos | Seleccionadas: S3, S1. Pendientes: S2, S4 |
| 3 | 0 minutos | Cola vacía; pendientes sin cambios |
| 4a | Rango `[50, 70]` | 5 equipos |
| 4a | Rango `[70, 50]` | 0 |
