package edu.unimagdalena.pw.aerolinia.Repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unimagdalena.pw.aerolinia.Entidades.ERole;
import edu.unimagdalena.pw.aerolinia.Entidades.Role;

public interface RoleRepository extends JpaRepository<Role,Long>{
    Optional<Role> findByName(ERole name);
}
