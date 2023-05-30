package edu.unimagdalena.pw.aerolinia.Repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.unimagdalena.pw.aerolinia.Entidades.Vuelo;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo, Long>{
 
    List<Vuelo> findByCodAeropSalidaAndCodAeropLlegadaAndFechaSalida(String codAeropSalida, String codAeropLlegada, String fechaSalida);
    List<Vuelo> findByCodAeropSalidaAndFechaSalida(String codAeropSalida, String fechaSalida);
    List<Vuelo> findByFechaSalida(String fechaSalida);
}
