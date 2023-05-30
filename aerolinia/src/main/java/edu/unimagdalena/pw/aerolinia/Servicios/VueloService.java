package edu.unimagdalena.pw.aerolinia.Servicios;

import java.util.List;
import java.util.Optional;


import edu.unimagdalena.pw.aerolinia.Entidades.Vuelo;

public interface VueloService {

    Vuelo create(Vuelo vuelo);
    void delete(Long id);
    List<Vuelo> findByFechaSalida(String fechaSalida);
    List<Vuelo> findByCodAeropSalYLlegFechaSal(String codAeropSalida, String codAeropLlegada, String fechaSalida);
    Optional<Vuelo> updateById(Long id, Vuelo vuelo);
    List<Vuelo> findByCodAeropSalYFechaSal(String codAeropSalida, String fechaSalida);

}
