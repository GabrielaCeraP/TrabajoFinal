package edu.unimagdalena.pw.aerolinia.Entidades;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users", uniqueConstraints = {
    @UniqueConstraint(columnNames = "nombreUsuario")
})
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Usuario{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nombreCompleto;

    @Column(nullable = false)
    private String nombreUsuario;

    @Column(nullable = false)
    private String contraseña;

    @OneToMany (mappedBy = "cliente")
    private Set<Reserva> reservas;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
                joinColumns = @JoinColumn(name="user_id"),
                inverseJoinColumns = @JoinColumn(name="role_id"))
    private Set<Role> roles = new HashSet<>();

    public Usuario(Long id, String nombreCompleto, String nombreUsuario, String contraseña) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
    }

    public Usuario(String nombreUsuario, String nombreCompleto, String contraseña, Set<Role> roles) {
        this.nombreCompleto = nombreCompleto;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.roles = roles;
    }

    public Usuario(String nombreUsuario, String nombreCompleto, String contraseña) {
        this.nombreUsuario = nombreUsuario;
        this.nombreCompleto = nombreCompleto;
        this.contraseña = contraseña;
    }

    
    public Usuario(Long id, String nombreCompleto, String nombreUsuario, String contraseña, Set<Reserva> reservas) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.reservas = reservas;
    }

    public Usuario UpdateWidth(Usuario oldUsuario ){
        return new Usuario(this.id, oldUsuario.getNombreCompleto(), oldUsuario.getNombreUsuario(), oldUsuario.getContraseña(), oldUsuario.getReservas());
    }


}
