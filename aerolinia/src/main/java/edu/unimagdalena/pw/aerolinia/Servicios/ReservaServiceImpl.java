package edu.unimagdalena.pw.aerolinia.Servicios;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import edu.unimagdalena.pw.aerolinia.Entidades.EstadoReserva;
import edu.unimagdalena.pw.aerolinia.Entidades.Reserva;
import edu.unimagdalena.pw.aerolinia.Entidades.Usuario;
import edu.unimagdalena.pw.aerolinia.Entidades.Vuelo;
import edu.unimagdalena.pw.aerolinia.Repositorios.ReservaRepository;

@Service
public class ReservaServiceImpl implements ReservaService {

    private final ReservaRepository reservaR;
    public ReservaServiceImpl(ReservaRepository reservaR) {
        this.reservaR = reservaR;
    }

    @Override
    public Reserva create(Reserva reserva) {
        Reserva reser = new Reserva(null, reserva.getEstado(), reserva.getFactura(), reserva.isAprobado(), reserva.getGeneradoEn(), reserva.getRefReserva(), reserva.getCliente(), reserva.getVueloSalida());
        return reservaR.save(reser);
    }

    @Override
    public Reserva createByUsuarioAndVuelo(Usuario usuario, Vuelo vuelo) {
        Reserva reser = new Reserva(usuario, vuelo);
        return reservaR.save(reser);
    }

    @Override
    public void deleteReserva(Long id) {
        reservaR.deleteById(id);
    }

    @Override
    public List<Reserva> findByClienteName(String clienteName) {
       return  reservaR.findByClienteName(clienteName);
    }

    @Override
    public List<Reserva> findByEstado(EstadoReserva estado) {
       return reservaR.findByEstado(estado);
    }

    @Override
    public Optional<Reserva> findById(Long id) {
       return reservaR.findById(id);
    }

    @Override
    public List<Reserva> findByVueloId(Long vuelo) {
        return reservaR.findByVueloId(vuelo);
    }

    @Override
    public Optional<Reserva> updateReserva(Long id, Reserva ReservaAnterior) {
        return reservaR.findById(id).map(reserV ->{
            Reserva reserva = reserV.UpdateWidth(ReservaAnterior);
            return reservaR.save(reserva);
        });
    }

    @Override
    public List<Reserva> findByEstadoAndClienteName(EstadoReserva estado, String clienteName) {
        return reservaR.findByEstadoAndClienteName(estado, clienteName);
    }

    @Override
    public List<Reserva> findAll() {
        return reservaR.findAll();
    }
  
}
