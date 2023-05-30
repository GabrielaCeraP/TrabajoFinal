package edu.unimagdalena.pw.aerolinia.Repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.unimagdalena.pw.aerolinia.Entidades.Usuario;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByNombreUsuario(String username);
    Boolean existsByNombreUsuario(String username);
    Boolean existsByNombreCompleto(String fullname);
}
