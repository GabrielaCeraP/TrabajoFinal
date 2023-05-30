package edu.unimagdalena.pw.aerolinia.Dtos.ReservaDtos;

import org.springframework.stereotype.Component;

import edu.unimagdalena.pw.aerolinia.Entidades.Reserva;

@Component
public class ReservaMapper {
    public ReservaMapper(){

    }

    public ReservaDto toDto(Reserva reserva){
        ReservaDto reservaDto = new ReservaDto();

        reservaDto.setEstado(reserva.getEstado());
        reservaDto.setVueloSalida(reserva.getVueloSalida());
        reservaDto.setFactura(reserva.getFactura());
        reservaDto.setAprobado(reserva.isAprobado());
        reservaDto.setCliente(reserva.getCliente());
        reservaDto.setGeneradoEn(reserva.getGeneradoEn());
        reservaDto.setRefReserva(reserva.getRefReserva());

        return reservaDto;
    }

    public Reserva toEntity(ReservaDto reservaDto){
        Reserva reser= new Reserva();

        reser.setEstado(reservaDto.getEstado());
        reser.setVueloSalida(reservaDto.getVueloSalida());
        reser.setFactura(reservaDto.getFactura());
        reser.setAprobado(reservaDto.isAprobado());
        reser.setCliente(reservaDto.getCliente());
        reser.setGeneradoEn(reservaDto.getGeneradoEn());
        reser.setRefReserva(reservaDto.getRefReserva());

        return reser;

    }

    public ReservaCreateDto toReservaCreate(Reserva reserva){
        ReservaCreateDto reservaDtoCreada = new ReservaCreateDto();

        reservaDtoCreada.setEstado(reserva.getEstado());
        reservaDtoCreada.setVueloSalida(reserva.getVueloSalida());
        reservaDtoCreada.setFactura(reserva.getFactura());
        reservaDtoCreada.setAprobado(reserva.isAprobado());
        reservaDtoCreada.setCliente(reserva.getCliente());
        reservaDtoCreada.setGeneradoEn(reserva.getGeneradoEn());
        reservaDtoCreada.setRefReserva(reserva.getRefReserva());

        return reservaDtoCreada;
    }

    public Reserva toBookingEntity(ReservaCreateDto reserCreada){
        Reserva reserva = new Reserva();

        reserva.setEstado(reserCreada.getEstado());
        reserva.setVueloSalida(reserCreada.getVueloSalida());
        reserva.setFactura(reserCreada.getFactura());
        reserva.setAprobado(reserCreada.isAprobado());
        reserva.setCliente(reserCreada.getCliente());
        reserva.setGeneradoEn(reserCreada.getGeneradoEn());
        reserva.setRefReserva(reserCreada.getRefReserva());

        return reserva;

    }

}
