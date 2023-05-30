package edu.unimagdalena.pw.aerolinia.Repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.unimagdalena.pw.aerolinia.Entidades.EstadoReserva;
import edu.unimagdalena.pw.aerolinia.Entidades.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva,Long>{
    List<Reserva> findByClienteName(String clienteName);
    List<Reserva> findByEstado(EstadoReserva estado);
    List<Reserva> findByEstadoAndClienteName(EstadoReserva estado, String clienteName);
    List<Reserva> findByVueloId(Long vuelo);
    List<Reserva> findAll();
}
