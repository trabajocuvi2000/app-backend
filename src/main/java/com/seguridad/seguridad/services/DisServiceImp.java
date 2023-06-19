
package com.seguridad.seguridad.services;

import com.seguridad.seguridad.entities.Dis;
import com.seguridad.seguridad.repository.DisRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisServiceImp implements DisService{

     @Autowired
    private DisRepo repositorio;
    @Override
    public Dis insertarDispositivo(Dis dispositivo) {
        return repositorio.save(dispositivo);
    }

    @Override
    public List<Dis> listarDispositivos() {
        return repositorio.findAll();
    }

    @Override
    public Optional<Dis> listarComunidadID(int id) {
        return  repositorio.findById(id);
    }

    @Override
    public Dis editarComunidad(Dis comunidad) {
        return  repositorio.save(comunidad);
    }

    @Override
    public Optional<Dis> eliminarComunidad(int id) {
        Optional<Dis> comunidad = repositorio.findById(id);
        if(comunidad!=null){//comprobamos si el objeto existe
            repositorio.deleteById(id);
        }
        return comunidad;
    }
    
}
