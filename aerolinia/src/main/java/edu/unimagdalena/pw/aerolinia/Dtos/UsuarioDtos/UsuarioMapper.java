package edu.unimagdalena.pw.aerolinia.Dtos.UsuarioDtos;

import org.springframework.stereotype.Component;

import edu.unimagdalena.pw.aerolinia.Entidades.Usuario;

@Component
public class UsuarioMapper {
    public UsuarioMapper(){

    }
    public UsuarioDto toDto(Usuario usuario){
        UsuarioDto usuarioDto= new UsuarioDto();
        usuarioDto.setNombreCompleto(usuario.getNombreCompleto());
        usuarioDto.setNombreUsuario(usuario.getNombreUsuario());
        usuarioDto.setContraseña(usuario.getContraseña());
        return usuarioDto;
    }
    public Usuario toEntity(UsuarioDto usuarioDto){
        Usuario usuario= new Usuario();
        usuario.setNombreCompleto(usuarioDto.getNombreCompleto());
        usuario.setNombreUsuario(usuarioDto.getNombreUsuario());
        usuario.setContraseña(usuarioDto.getContraseña());
        return usuario;
    }
    public UsuarioCreateDto toUsuarioCreateDto(Usuario usuario){
        UsuarioCreateDto usuarioCreateDto= new UsuarioCreateDto();
        usuarioCreateDto.setId(usuario.getId());
        usuarioCreateDto.setNombreCompleto(usuario.getNombreCompleto());
        usuarioCreateDto.setNombreUsuario(usuario.getNombreUsuario());
        usuarioCreateDto.setContraseña(usuario.getContraseña());

        return usuarioCreateDto;
    }
    public Usuario toUsuarioEntity(UsuarioCreateDto usuarioCreateDto){
        Usuario usuario= new Usuario();
        usuario.setNombreCompleto(usuarioCreateDto.getNombreCompleto());
        usuario.setNombreUsuario(usuarioCreateDto.getNombreUsuario());
        usuario.setContraseña(usuarioCreateDto.getContraseña());

        return usuario;
    }
}
