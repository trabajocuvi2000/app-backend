
package com.seguridad.seguridad.services;

import com.seguridad.seguridad.entities.Dispositivo;
import com.seguridad.seguridad.repository.DispositivoRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DispositivoServiceImp implements DispositivoService{
    
    @Autowired
    private DispositivoRepo repositorio;

    @Override
    public Dispositivo insertarDispositivo(Dispositivo dispositivo) {
        return repositorio.save(dispositivo);
    }

    @Override
    public List<Dispositivo> listarDispositivos() {
        return repositorio.findAll();
    }

    @Override
    public Optional<Dispositivo> listarDispositivoID(int id) {
        return repositorio.findById(id);
    }

    @Override
    public Dispositivo editarDispositivo(Dispositivo dispositivo) {
        return repositorio.save(dispositivo);
    }

    @Override
    public Optional<Dispositivo> eliminarDispositivo(int id) {
        Optional<Dispositivo> dispositivo = repositorio.findById(id);
        if(dispositivo!=null){//comprobamos si el objeto existe
            repositorio.deleteById(id);
        }
        return dispositivo;
    }
    
}
