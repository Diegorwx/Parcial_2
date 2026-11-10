package co.edu.uniquindio.poo;

public class SeleccionnSolicitudes {
    static class Solicitud {
        private String codigo;
        private Prioridad prioridad;
        private int  duracion;

        Solicitud(String codigo, Prioridad prioridad, int duracion) {
            this.codigo = codigo;
            this.prioridad = prioridad;
            this.duracion = duracion;
        }


        public String getCodigo() {
            return codigo;
        }

        public Prioridad getPrioridad() {
            return prioridad;
        }

        public int getDuracion() {
            return duracion;
        }

    }
    
}
