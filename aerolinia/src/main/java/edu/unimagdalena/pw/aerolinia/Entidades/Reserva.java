package edu.unimagdalena.pw.aerolinia.Entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table(name = "Reservas")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private EstadoReserva estado;
    
    @Column(nullable = false)
    private String factura;
    @Column(nullable = false)
    private boolean aprobado;
    @Column(nullable = false)
    private String generadoEn;
    @Column(nullable = false)
    private String refReserva;
    
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Usuario cliente;
    @ManyToOne
    @JoinColumn(name = "vueloSalida_id")
    private Vuelo vueloSalida;

    public Reserva(Usuario cliente,Vuelo vueloSalida){
        this.cliente = cliente;
        this.vueloSalida = vueloSalida;
    }
    
    public Reserva UpdateWidth(Reserva reservaAnterior){
        return new Reserva(this.id, reservaAnterior.getEstado(), reservaAnterior.getFactura(), reservaAnterior.isAprobado(), reservaAnterior.getGeneradoEn(), reservaAnterior.getRefReserva(), reservaAnterior.getCliente(), reservaAnterior.getVueloSalida());
    }
}