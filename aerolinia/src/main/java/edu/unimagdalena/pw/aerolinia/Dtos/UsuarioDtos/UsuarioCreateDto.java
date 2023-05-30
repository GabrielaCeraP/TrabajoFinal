package edu.unimagdalena.pw.aerolinia.Dtos.UsuarioDtos;
import lombok.Data;

@Data
public class UsuarioCreateDto{
    private Long id;
    private String nombreCompleto;
    private String nombreUsuario;
    private String contraseña;
}