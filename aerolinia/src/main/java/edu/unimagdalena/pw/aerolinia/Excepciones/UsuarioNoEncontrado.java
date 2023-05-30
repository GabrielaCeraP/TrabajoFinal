package edu.unimagdalena.pw.aerolinia.Excepciones;

public class UsuarioNoEncontrado extends RuntimeException{
    String mensaje;

    public UsuarioNoEncontrado(){
        super("Usuario no encontrado");
    }

    public UsuarioNoEncontrado(String mensaje){
        this.mensaje = mensaje;
    }
}
