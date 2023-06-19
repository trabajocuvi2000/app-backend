
package com.seguridad.seguridad.services;

import com.seguridad.seguridad.entities.Emergencia;
import com.seguridad.seguridad.repository.EmergenciaRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmergenciaServiceImp implements EmergenciaService{
    
    @Autowired
    private EmergenciaRepo repositorio;

    @Override
    public Emergencia insertarEmergencia(Emergencia emergencia) {
        return repositorio.save(emergencia);
    }

    @Override
    public List<Emergencia> listarEmergencias() {
        return repositorio.findAll();
    }

    @Override
    public Optional<Emergencia> listarEmergenciaID(int id) {
        return repositorio.findById(id);
    }

    @Override
    public Emergencia editarEmergencia(Emergencia emergencia) {
        return repositorio.save(emergencia);
    }

    @Override
    public Optional<Emergencia> eliminarEmergencia(int id) {
        Optional<Emergencia> emergencia = repositorio.findById(id);
        if(emergencia!=null){//comprobamos si el objeto existe
            repositorio.deleteById(id);
        }
        return emergencia;
    }
    
}
