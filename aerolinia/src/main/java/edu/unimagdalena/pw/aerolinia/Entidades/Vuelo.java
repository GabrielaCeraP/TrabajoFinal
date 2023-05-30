package edu.unimagdalena.pw.aerolinia.Entidades;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "Vuelos")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Vuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String fechaSalida;
    @Column(nullable = false)
    private String codAeropSalida;
    @Column(nullable = false)
    private String nameAeropSalida;
    @Column(nullable = false)
    private String ciudadSalida;
    @Column(nullable = false)
    private String localidadSalida;
    
    @Column(nullable = false)
    private String fechaLlegada;
    @Column(nullable = false)
    private String codAeropLlegada;
    @Column(nullable = false)
    private String nameAeropLlegada;
    @Column(nullable = false)
    private String ciudadLlegada;
    @Column(nullable = false)
    private String localidadLlegada;
    
    @Column(nullable = false)
    private int precioBoleto;
    @Column(nullable = false)
    private String tipoMoneda;
    @Column(nullable = false)
    private int numVuelo;
    @Column(nullable = false)
    private int numAsientos;

    @OneToMany(mappedBy = "vueloSalida")
    private Set<Reserva> reservas;
    
    public Vuelo(Long id, String fechaSalida, String codAeropSalida, String nameAeropSalida, String ciudadSalida,
            String localidadSalida, String fechaLlegada, String codAeropLlegada, String nameAeropLlegada,
            String ciudadLlegada, String localidadLlegada, int precioBoleto, String tipoMoneda, int numVuelo,
            int numAsientos) {
        this.id = id;
        this.fechaSalida = fechaSalida;
        this.codAeropSalida = codAeropSalida;
        this.nameAeropSalida = nameAeropSalida;
        this.ciudadSalida = ciudadSalida;
        this.localidadSalida = localidadSalida;
        this.fechaLlegada = fechaLlegada;
        this.codAeropLlegada = codAeropLlegada;
        this.nameAeropLlegada = nameAeropLlegada;
        this.ciudadLlegada = ciudadLlegada;
        this.localidadLlegada = localidadLlegada;
        this.precioBoleto = precioBoleto;
        this.tipoMoneda = tipoMoneda;
        this.numVuelo = numVuelo;
        this.numAsientos = numAsientos;
    }

    public Vuelo UpdateWidth(Vuelo vuelo){
        return new Vuelo(this.id, vuelo.getFechaSalida(), vuelo.getCodAeropSalida(), 
        vuelo.getNameAeropSalida(), vuelo.getCiudadSalida(), vuelo.getLocalidadSalida(), 
        vuelo.getFechaLlegada(), vuelo.getCodAeropLlegada(), vuelo.getNameAeropLlegada(), 
        vuelo.getCiudadLlegada(), vuelo.getLocalidadLlegada(), vuelo.getPrecioBoleto(), 
        vuelo.getTipoMoneda(), vuelo.getNumVuelo(), vuelo.getNumAsientos());
    }
}
