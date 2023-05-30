package edu.unimagdalena.pw.aerolinia.Dtos.VueloDtos;

import org.springframework.stereotype.Component;

import edu.unimagdalena.pw.aerolinia.Entidades.Vuelo;

@Component
public class VueloMapper {
    public VueloMapper(){

    }

    public VueloDto toDto(Vuelo vuelo){
        VueloDto vueloDto= new VueloDto();
        vueloDto.setFechaSalida(vuelo.getFechaSalida());
        vueloDto.setCodAeropSalida(vuelo.getCodAeropSalida());
        vueloDto.setNameAeropSalida(vuelo.getNameAeropSalida());
        vueloDto.setCiudadSalida(vuelo.getCiudadSalida());
        vueloDto.setLocalidadSalida(vuelo.getLocalidadSalida());
        vueloDto.setLocalidadLlegada(vuelo.getLocalidadLlegada());
        vueloDto.setCodAeropLlegada(vuelo.getCodAeropLlegada());
        vueloDto.setNameAeropSalida(vuelo.getNameAeropSalida());
        vueloDto.setCiudadLlegada(vuelo.getCiudadLlegada());
        vueloDto.setLocalidadLlegada(vuelo.getLocalidadLlegada());
        vueloDto.setPrecioBoleto(vuelo.getPrecioBoleto());
        vueloDto.setTipoMoneda(vuelo.getTipoMoneda());
        vueloDto.setNumVuelo(vuelo.getNumVuelo());
        vueloDto.setNumAsientos(vuelo.getNumAsientos());
        return vueloDto;
    }

    public Vuelo toEntity(VueloDto vueloDTO){
        Vuelo vuelo = new Vuelo();

        vuelo.setFechaSalida(vueloDTO.getFechaSalida());
        vuelo.setCodAeropSalida(vueloDTO.getCodAeropSalida());
        vuelo.setNameAeropSalida(vueloDTO.getNameAeropSalida());
        vuelo.setCiudadSalida(vueloDTO.getCiudadSalida());
        vuelo.setLocalidadSalida(vueloDTO.getLocalidadSalida());
        vuelo.setLocalidadLlegada(vueloDTO.getLocalidadLlegada());
        vuelo.setCodAeropLlegada(vueloDTO.getCodAeropLlegada());
        vuelo.setNameAeropSalida(vueloDTO.getNameAeropSalida());
        vuelo.setCiudadLlegada(vueloDTO.getCiudadLlegada());
        vuelo.setLocalidadLlegada(vueloDTO.getLocalidadLlegada());
        vuelo.setPrecioBoleto(vueloDTO.getPrecioBoleto());
        vuelo.setTipoMoneda(vueloDTO.getTipoMoneda());
        vuelo.setNumVuelo(vueloDTO.getNumVuelo());
        vuelo.setNumAsientos(vueloDTO.getNumAsientos());

        return vuelo;
    }


    public VueloCreateDto toVueloCreateDto(Vuelo vuelo){
        VueloCreateDto vueloCreado= new VueloCreateDto();

        vueloCreado.setFechaSalida(vuelo.getFechaSalida());
        vueloCreado.setCodAeropSalida(vuelo.getCodAeropSalida());
        vueloCreado.setNameAeropSalida(vuelo.getNameAeropSalida());
        vueloCreado.setCiudadSalida(vuelo.getCiudadSalida());
        vueloCreado.setLocalidadSalida(vuelo.getLocalidadSalida());
        vueloCreado.setLocalidadLlegada(vuelo.getLocalidadLlegada());
        vueloCreado.setCodAeropLlegada(vuelo.getCodAeropLlegada());
        vueloCreado.setNameAeropSalida(vuelo.getNameAeropSalida());
        vueloCreado.setCiudadLlegada(vuelo.getCiudadLlegada());
        vueloCreado.setLocalidadLlegada(vuelo.getLocalidadLlegada());
        vueloCreado.setPrecioBoleto(vuelo.getPrecioBoleto());
        vueloCreado.setTipoMoneda(vuelo.getTipoMoneda());
        vueloCreado.setNumVuelo(vuelo.getNumVuelo());
        vueloCreado.setNumAsientos(vuelo.getNumAsientos());

        return vueloCreado;
    }

    public Vuelo toVueloEntity(VueloDto vueloCreadoDto){
        Vuelo vuelo = new Vuelo();

        vuelo.setFechaSalida(vueloCreadoDto.getFechaSalida());
        vuelo.setCodAeropSalida(vueloCreadoDto.getCodAeropSalida());
        vuelo.setNameAeropSalida(vueloCreadoDto.getNameAeropSalida());
        vuelo.setCiudadSalida(vueloCreadoDto.getCiudadSalida());
        vuelo.setLocalidadSalida(vueloCreadoDto.getLocalidadSalida());
        vuelo.setLocalidadLlegada(vueloCreadoDto.getLocalidadLlegada());
        vuelo.setCodAeropLlegada(vueloCreadoDto.getCodAeropLlegada());
        vuelo.setNameAeropSalida(vueloCreadoDto.getNameAeropSalida());
        vuelo.setCiudadLlegada(vueloCreadoDto.getCiudadLlegada());
        vuelo.setLocalidadLlegada(vueloCreadoDto.getLocalidadLlegada());
        vuelo.setPrecioBoleto(vueloCreadoDto.getPrecioBoleto());
        vuelo.setTipoMoneda(vueloCreadoDto.getTipoMoneda());
        vuelo.setNumVuelo(vueloCreadoDto.getNumVuelo());
        vuelo.setNumAsientos(vueloCreadoDto.getNumAsientos());

        return vuelo;
    }
    
}
