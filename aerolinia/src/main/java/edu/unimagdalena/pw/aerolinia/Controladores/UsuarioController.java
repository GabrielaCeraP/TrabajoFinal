package edu.unimagdalena.pw.aerolinia.Controladores;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.unimagdalena.pw.aerolinia.Dtos.UsuarioDtos.UsuarioCreateDto;
import edu.unimagdalena.pw.aerolinia.Dtos.UsuarioDtos.UsuarioDto;
import edu.unimagdalena.pw.aerolinia.Dtos.UsuarioDtos.UsuarioMapper;
import edu.unimagdalena.pw.aerolinia.Entidades.Usuario;
import edu.unimagdalena.pw.aerolinia.Servicios.UsuarioService;

@RestController
@RequestMapping("/api/v1")
public class  UsuarioController{
    private UsuarioService servicio;
    private UsuarioMapper mapeador;
    

    public UsuarioController(UsuarioService servicio, UsuarioMapper mapeador) {
        this.servicio = servicio;
        this.mapeador = mapeador;
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<UsuarioCreateDto> findById(@PathVariable Long id){
        UsuarioCreateDto usuarioCreado = servicio.findById(id).map(u -> mapeador.toUsuarioCreateDto(u)).orElseThrow();
        return ResponseEntity.status(HttpStatus.FOUND).body(usuarioCreado);
    }
  
    @GetMapping("/usuarios/")
    public ResponseEntity<List<UsuarioCreateDto>> listarUsuarios(){
        List<Usuario> usuarios = servicio.findAll();
        List<UsuarioCreateDto> usuariosDTO = usuarios.stream().map(u -> mapeador.toUsuarioCreateDto(u)).collect(Collectors.toList());
        return ResponseEntity.ok().body(usuariosDTO);
    }

    @PostMapping("/usuarios/")
        public ResponseEntity<UsuarioCreateDto> create (@RequestBody UsuarioDto usuario){
        Usuario usuarioNuevo = mapeador.toEntity(usuario);
        Usuario usuarioCreado = null;

        usuarioCreado = servicio.create(usuarioNuevo);
        UsuarioCreateDto crearUsuario = mapeador.toUsuarioCreateDto(usuarioCreado);
        URI locacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(crearUsuario.getId()).toUri();
        return ResponseEntity.created(locacion).body(crearUsuario);
    }


    @DeleteMapping("/usuarios/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteById (@PathVariable Long id){
        servicio.delete(id);
        return ResponseEntity.noContent().build();
    }

   
    @PutMapping("/usuarios/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UsuarioCreateDto> updateVuelo (@PathVariable Long id , @RequestBody UsuarioDto usuarioDto){
        Usuario datoUsuario = mapeador.toEntity(usuarioDto);
        return servicio.update(id, datoUsuario).map(objActualizado-> ResponseEntity.ok().body(mapeador.toUsuarioCreateDto(objActualizado))).orElseGet(()->{
            Usuario usuarioUpdate = servicio.create(datoUsuario);
            UsuarioCreateDto crearUsuarioDto = mapeador.toUsuarioCreateDto(usuarioUpdate);
            URI locacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(crearUsuarioDto.getId()).toUri();
            return ResponseEntity.created(locacion).body(crearUsuarioDto);
        });
    }
   

    
    
}



