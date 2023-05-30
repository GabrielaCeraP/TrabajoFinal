package edu.unimagdalena.pw.aerolinia.Excepciones;

public class ReservaNoAprobada extends RuntimeException{
    String mensaje;

    public ReservaNoAprobada(){
        super("Su reserva no ha sido aprobada");
    }
    public ReservaNoAprobada(String mensaje){
        this.mensaje=mensaje;
    }
}
