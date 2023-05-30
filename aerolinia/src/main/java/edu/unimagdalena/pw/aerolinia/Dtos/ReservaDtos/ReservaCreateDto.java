package edu.unimagdalena.pw.aerolinia.Dtos.ReservaDtos;

import edu.unimagdalena.pw.aerolinia.Entidades.EstadoReserva;
import edu.unimagdalena.pw.aerolinia.Entidades.Usuario;
import edu.unimagdalena.pw.aerolinia.Entidades.Vuelo;
import lombok.Data;

@Data
public class ReservaCreateDto {
    private Long id;
    private EstadoReserva estado;
    private String factura;
    private boolean aprobado;
    private String generadoEn;
    private String refReserva;
    private Usuario cliente;
    private Vuelo vueloSalida;
}
