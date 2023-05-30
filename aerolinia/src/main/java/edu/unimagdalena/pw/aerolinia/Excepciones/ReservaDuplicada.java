package edu.unimagdalena.pw.aerolinia.Excepciones;

public class ReservaDuplicada extends RuntimeException {
    String mensaje;
        public ReservaDuplicada(){
        super("Reserva duplicada");
    }

    public ReservaDuplicada(String mensaje){
        this.mensaje = mensaje;
    }
}

