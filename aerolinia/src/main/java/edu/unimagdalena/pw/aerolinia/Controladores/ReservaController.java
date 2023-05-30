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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.unimagdalena.pw.aerolinia.Dtos.ReservaDtos.ReservaCreateDto;
import edu.unimagdalena.pw.aerolinia.Dtos.ReservaDtos.ReservaDto;
import edu.unimagdalena.pw.aerolinia.Dtos.ReservaDtos.ReservaMapper;
import edu.unimagdalena.pw.aerolinia.Entidades.EstadoReserva;
import edu.unimagdalena.pw.aerolinia.Entidades.Reserva;
import edu.unimagdalena.pw.aerolinia.Entidades.Usuario;
import edu.unimagdalena.pw.aerolinia.Entidades.Vuelo;
import edu.unimagdalena.pw.aerolinia.Servicios.ReservaService;

@RestController
@RequestMapping("/api/v1")
public class ReservaController {
    private ReservaService servicio;
    private ReservaMapper mapeador;

    public ReservaController(ReservaService servicio, ReservaMapper mapeador) {
        this.servicio=servicio;
        this.mapeador =mapeador;
    }

    @GetMapping("/reservas/{id}")
    public ResponseEntity<ReservaCreateDto> findById(@PathVariable Long id){
        ReservaCreateDto reservaCreada = servicio.findById(id).map(b -> mapeador.toReservaCreate(b)).orElseThrow();
        return ResponseEntity.status(HttpStatus.FOUND).body(reservaCreada);
    }

        /*status, customerName
        Ejemplo:/booking/
        /booking/?status=CONFIRMED
        /booking/?customerName=juan
        /booking/?status=UNCONFIRMED&customerName=miguel */
    
    @GetMapping("/reservas/")
    public ResponseEntity<List<ReservaCreateDto>> findByManyParameters(
        @RequestParam(name = "status", required = false) EstadoReserva status, 
        @RequestParam(name = "customerName", required = false) String customerName) {
    
        List<Reserva> reservas;
        if (status != null && customerName != null) {
            reservas = servicio.findByEstadoAndClienteName(status, customerName);
        } else if (status != null ) {
            reservas = servicio.findByEstado(status);
        } else if (customerName != null) {
            reservas = servicio.findByClienteName(customerName);
        } else {
            reservas = servicio.findAll();
        }
        
        List<ReservaCreateDto> ReservaDTO = reservas.stream().map(b -> mapeador.toReservaCreate(b)).collect(Collectors.toList());
        return ResponseEntity.ok().body(ReservaDTO);
    }

    /*/booking/flight/:idflight/user/:iduser idflightiduserEjemplo:/booking/flight/1/user/5*/
    @PostMapping("/reservas/vuelo/{id}/usuario/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<ReservaCreateDto> createByUsuarioAndVuelo(@RequestBody Usuario usuario, @RequestBody Vuelo vuelo, @RequestBody ReservaDto reser){
        Reserva ReservaCreada = null;
        ReservaCreada= servicio.createByUsuarioAndVuelo(usuario, vuelo);
        ReservaCreateDto creadorReserva = mapeador.toReservaCreate(ReservaCreada);
        URI locacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(creadorReserva.getId()).toUri();
        return ResponseEntity.created(locacion).body(creadorReserva);
    }

    @DeleteMapping("/reservas/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteById (@PathVariable Long id){
        servicio.deleteReserva(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/reservas/vuelos/{id}")
    public ResponseEntity<List<ReservaCreateDto>> findByVuelo(@PathVariable Vuelo vuelo){
        List<Reserva> reservas = servicio.findByVueloId(vuelo.getId());
        List<ReservaCreateDto> trueReservas = reservas.stream().map(r -> mapeador.toReservaCreate(r)).collect(Collectors.toList());
        return ResponseEntity.ok().body(trueReservas);
    }

}
