package edu.unimagdalena.pw.aerolinia.Excepciones;

public class ReservaNoEncontrada extends RuntimeException{
    String mensaje;

    public ReservaNoEncontrada(){
        super("No se encuentra la reserva");
    }
    public ReservaNoEncontrada(String mensaje){
        this.mensaje=mensaje;
    }
}
