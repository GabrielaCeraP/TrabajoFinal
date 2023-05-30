package edu.unimagdalena.pw.aerolinia.Servicios;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import edu.unimagdalena.pw.aerolinia.Entidades.Vuelo;
import edu.unimagdalena.pw.aerolinia.Repositorios.VueloRepository;

@Service
public class VueloServiceImpl implements VueloService {
    private final VueloRepository vueloR;
    public VueloServiceImpl(VueloRepository vueloR) {
        this.vueloR = vueloR;
    }

    @Override
    public Vuelo create(Vuelo vuelo) {
        Vuelo flight= new Vuelo(null, vuelo.getFechaSalida(), vuelo.getCodAeropSalida(), vuelo.getNameAeropSalida(), 
        vuelo.getCiudadSalida(), vuelo.getLocalidadSalida(), vuelo.getFechaLlegada(), vuelo.getCodAeropLlegada(), 
        vuelo.getNameAeropLlegada(), vuelo.getCiudadLlegada(), vuelo.getLocalidadLlegada(), vuelo.getPrecioBoleto(), 
        vuelo.getTipoMoneda(), vuelo.getNumVuelo(), vuelo.getNumAsientos());
        return vueloR.save(flight);
    }

    @Override
    public void delete(Long id) {
        vueloR.deleteById(id);
    }

    @Override
    public List<Vuelo> findByFechaSalida(String fechaSalida) {
        return vueloR.findByFechaSalida(fechaSalida);
    }

    @Override
    public List<Vuelo> findByCodAeropSalYLlegFechaSal(String codAeropSalida, String codAeropLlegada,String fechaSalida) {
      return vueloR.findByCodAeropSalidaAndCodAeropLlegadaAndFechaSalida(codAeropSalida, codAeropLlegada, fechaSalida);
    }

    
    @Override
    public Optional<Vuelo> updateById(Long id, Vuelo vuelo) {
        return vueloR.findById(id).map(flight -> {
            Vuelo vuel=flight.UpdateWidth(vuelo);
            return vueloR.save(vuel);
        });
    }

    @Override
    public List<Vuelo> findByCodAeropSalYFechaSal(String codAeropSalida, String fechaSalida) {
        return vueloR.findByCodAeropSalidaAndFechaSalida(codAeropSalida, fechaSalida);
    }
    
}
