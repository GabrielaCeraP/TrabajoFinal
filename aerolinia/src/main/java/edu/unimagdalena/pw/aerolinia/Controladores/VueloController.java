package edu.unimagdalena.pw.aerolinia.Controladores;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.unimagdalena.pw.aerolinia.Dtos.VueloDtos.VueloCreateDto;
import edu.unimagdalena.pw.aerolinia.Dtos.VueloDtos.VueloDto;
import edu.unimagdalena.pw.aerolinia.Dtos.VueloDtos.VueloMapper;
import edu.unimagdalena.pw.aerolinia.Entidades.Vuelo;
import edu.unimagdalena.pw.aerolinia.Servicios.VueloService;

@RestController
@RequestMapping("/api/v1")
public class VueloController {
    private VueloService servicio;

    private VueloMapper mapeador;

    @Autowired
    public VueloController(VueloService servicio, VueloMapper mapeador){
        this.servicio=servicio;
        this.mapeador=mapeador;
    }
///catalog/?departureAirportCode=LON&arrivalAirportCode=ARG&departureDate=2022-04-29
//se pone entre parentesis si se llaman diferente
    @GetMapping("/catalogos/")
    public ResponseEntity<List<VueloCreateDto>> findByManyParameters(@RequestParam("departureAirportCode") String departureAirportCode, 
    @RequestParam String arrivalAirportCode, @RequestParam String departureDate){
        List<Vuelo> vuelos = servicio.findByCodAeropSalYLlegFechaSal(departureAirportCode,arrivalAirportCode,departureDate);
        List<VueloCreateDto> trueVuelos = vuelos.stream().map(v-> mapeador.toVueloCreateDto(v)).collect(Collectors.toList());
        return ResponseEntity.ok().body(trueVuelos);

    }

    @PostMapping("/catalogos/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<VueloCreateDto> create (@RequestBody VueloDto vuelo){
        Vuelo vueloNuevo = mapeador.toEntity(vuelo);
        Vuelo vueloCreado = null;

        vueloCreado = servicio.create(vueloNuevo);
        VueloCreateDto crearVuelo = mapeador.toVueloCreateDto(vueloCreado);
        URI locacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(crearVuelo.getId()).toUri();
        return ResponseEntity.created(locacion).body(crearVuelo);
    }

    @PutMapping("/catalogos/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    //public ResponseEntity<VueloCreateDto> updateVuelo (@PathVariable ("id") Long idVuelo) // otra manera
    public ResponseEntity<VueloCreateDto> updateVuelo (@PathVariable Long id , @RequestBody VueloDto vueloDto){
        Vuelo datoVuelo = mapeador.toEntity(vueloDto);
        return servicio.updateById(id, datoVuelo).map(objActualizado-> ResponseEntity.ok().body(mapeador.toVueloCreateDto(objActualizado))).orElseGet(()->{
            Vuelo vueloUpdate = servicio.create(datoVuelo);
            VueloCreateDto crearVueloDto = mapeador.toVueloCreateDto(vueloUpdate);
            URI locacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(crearVueloDto.getId()).toUri();
            return ResponseEntity.created(locacion).body(crearVueloDto);
    
        });
    }

    @DeleteMapping("/catalogos/{id}")
    public ResponseEntity<?> deleteById (@PathVariable Long id) {
        servicio.delete(id);
        return ResponseEntity.noContent().build();
    }
    ///catalog/MAD/?departureDate=2022-05-12
    ///catalog/:airportCode
    @GetMapping("/catalogos/{airportCode}")
    public ResponseEntity<List<VueloCreateDto>> buscVueloPorAreopuerto(@PathVariable String airportCode, @RequestParam String departureDate){
        List<Vuelo> vuelos = servicio.findByCodAeropSalYFechaSal(airportCode,departureDate);
        List<VueloCreateDto> trueVuelos = vuelos.stream().map(v-> mapeador.toVueloCreateDto(v)).collect(Collectors.toList());
        return ResponseEntity.ok().body(trueVuelos);
    }
}
