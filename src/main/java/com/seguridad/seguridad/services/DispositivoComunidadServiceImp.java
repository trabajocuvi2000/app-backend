
package com.seguridad.seguridad.services;

import com.seguridad.seguridad.entities.DispositivoComunidad;
import com.seguridad.seguridad.repository.DispositivoComunidadRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DispositivoComunidadServiceImp implements DispositivoComunidadService{
    
    @Autowired
    private DispositivoComunidadRepo repositorio;

    @Override
    public DispositivoComunidad insertarDispositivoComunidad(DispositivoComunidad dispositivoComunidad) {
        return repositorio.save(dispositivoComunidad);
    }

    @Override
    public List<DispositivoComunidad> listarDispositivosComunidad() {
        return repositorio.findAll();
    }

    @Override
    public Optional<DispositivoComunidad> listarDispositivosComunidadId(int id) {
        return repositorio.findById(id);
    }

    @Override
    public DispositivoComunidad editarDispositivoComunidad(DispositivoComunidad dispositivoComunidad) {
        return  repositorio.save(dispositivoComunidad);
    }

    @Override
    public Optional<DispositivoComunidad> eliminarDispositivoComunidad(int id) {
        Optional<DispositivoComunidad> dispositivoComunidad = repositorio.findById(id);
        if(dispositivoComunidad!=null){//comprobamos si el objeto existe
            repositorio.deleteById(id);
        }
        return dispositivoComunidad;
    }
    
}
