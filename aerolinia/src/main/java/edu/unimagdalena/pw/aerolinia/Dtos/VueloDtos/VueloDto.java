package edu.unimagdalena.pw.aerolinia.Dtos.VueloDtos;

import lombok.Data;

@Data
public class VueloDto {
    private String fechaSalida;
    private String codAeropSalida;
    private String nameAeropSalida;
    private String ciudadSalida;
    private String localidadSalida;
    private String fechaLlegada;
    private String codAeropLlegada;
    private String nameAeropLlegada;
    private String ciudadLlegada;
    private String localidadLlegada;
    private int precioBoleto;
    private String tipoMoneda;
    private int numVuelo;
    private int numAsientos;
}
