
package com.seguridad.seguridad.services;

import com.seguridad.seguridad.entities.NivelEmergencia;
import com.seguridad.seguridad.repository.NivelEmergenciaRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NivelEmergenciaServiceImp implements NivelEmergenciaService{
    
    @Autowired
    private NivelEmergenciaRepo repositorio;

    @Override
    public NivelEmergencia insertarNivelEmergencia(NivelEmergencia nivelEmergencia) {
        return repositorio.save(nivelEmergencia);
    }

    @Override
    public List<NivelEmergencia> listarNivelEmergencias() {
        return repositorio.findAll();
    }

    @Override
    public Optional<NivelEmergencia> listarNivelEmegenciaID(int id) {
        return repositorio.findById(id);
    }

    @Override
    public NivelEmergencia editarNivelEmergencia(NivelEmergencia nivelEmergencia) {
        return repositorio.save(nivelEmergencia);
    }

    @Override
    public Optional<NivelEmergencia> eliminarNivelEmergencia(int id) {
        Optional<NivelEmergencia> nivelEmergencia = repositorio.findById(id);
        if(nivelEmergencia!=null){//comprobamos si el objeto existe
            repositorio.deleteById(id);
        }
        return nivelEmergencia;
    }
    
}
