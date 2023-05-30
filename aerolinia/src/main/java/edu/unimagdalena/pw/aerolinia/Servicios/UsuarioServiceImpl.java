package edu.unimagdalena.pw.aerolinia.Servicios;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import edu.unimagdalena.pw.aerolinia.Entidades.Usuario;
import edu.unimagdalena.pw.aerolinia.Repositorios.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    
    private final UsuarioRepository usuarioR;
    
    public UsuarioServiceImpl(UsuarioRepository usuarioR) {
        this.usuarioR = usuarioR;
    }

    @Override
    public Usuario getById(Long id) {
        return usuarioR.getReferenceById(id);
    }

    @Override
    public Usuario create(Usuario usuario) {
        Usuario user= new Usuario(null, usuario.getNombreCompleto(), usuario.getNombreUsuario(), usuario.getContraseña());
        return usuarioR.save(user);
    }

    @Override
    public Optional<Usuario> update(Long id, Usuario OldUsuario) {
       return usuarioR.findById(id).map(usuario->{
        Usuario usuari= usuario.UpdateWidth(OldUsuario);
        return usuarioR.save(usuari); 
       });
    }

    @Override
    public void delete(Long id) {
        usuarioR.deleteById(id);
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioR.findAll();
    }

    @Override
    public Optional<Usuario> findById(Long id) {
      return usuarioR.findById(id);
    }
    
}
