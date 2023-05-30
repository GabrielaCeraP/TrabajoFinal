package edu.unimagdalena.pw.aerolinia.Excepciones;

public class NumAsientosMax extends RuntimeException{
    String mensaje;

    public NumAsientosMax(){
        super("Ya no quedan más asientos disponibles");
    }
    public NumAsientosMax(String mensaje){
        this.mensaje=mensaje;
    }
}