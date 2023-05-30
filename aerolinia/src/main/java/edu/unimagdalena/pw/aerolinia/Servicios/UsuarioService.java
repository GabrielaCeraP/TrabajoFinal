package edu.unimagdalena.pw.aerolinia.Servicios;

import java.util.List;
import java.util.Optional;

import edu.unimagdalena.pw.aerolinia.Entidades.Usuario;

public interface UsuarioService {

    Usuario getById(Long id);
    Usuario create(Usuario usuario);
    Optional<Usuario> update(Long id,Usuario OldUsuario);
    void delete(Long id);
    List<Usuario> findAll();
    Optional<Usuario> findById(Long id);
}
