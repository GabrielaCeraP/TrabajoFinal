package edu.unimagdalena.pw.aerolinia.Servicios;

import java.util.List;
import java.util.Optional;

import edu.unimagdalena.pw.aerolinia.Entidades.EstadoReserva;
import edu.unimagdalena.pw.aerolinia.Entidades.Reserva;
import edu.unimagdalena.pw.aerolinia.Entidades.Usuario;
import edu.unimagdalena.pw.aerolinia.Entidades.Vuelo;

public interface ReservaService {
    List<Reserva> findByClienteName(String clienteName);
    List<Reserva> findByEstado(EstadoReserva estado);
    List<Reserva> findByVueloId(Long vuelo);
    List<Reserva> findByEstadoAndClienteName(EstadoReserva estado, String clienteName);
    List<Reserva> findAll();

    
    Reserva create (Reserva reserva);
    Reserva createByUsuarioAndVuelo(Usuario usuario, Vuelo vuelo);
    Optional<Reserva> updateReserva(Long id, Reserva ReservaAnterior);
    void deleteReserva(Long id);
    Optional<Reserva> findById(Long id);
}   
