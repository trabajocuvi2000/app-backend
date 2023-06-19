
package com.seguridad.seguridad.services;

import com.seguridad.seguridad.entities.TipoDispositivo;
import com.seguridad.seguridad.repository.TipoDispositivoRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoDispositivoServiceImp implements TipoDispositivoService{
    
    @Autowired
    private TipoDispositivoRepo repositorio;

    @Override
    public TipoDispositivo insertarTipoDispositivo(TipoDispositivo tipodDispositivo) {
        return repositorio.save(tipodDispositivo);
    }

    @Override
    public List<TipoDispositivo> listarTiposDispositivos() {
        return repositorio.findAll();
    }

    @Override
    public Optional<TipoDispositivo> listarTipoDispositivoID(int id) {
       return repositorio.findById(id);
    }

    @Override
    public TipoDispositivo editarTipoDispositivo(TipoDispositivo tipodDispositivo) {
        return repositorio.save(tipodDispositivo);
    }

    @Override
    public Optional<TipoDispositivo> eliminarTipoDispositivo(int id) {
        Optional<TipoDispositivo> tipoDispositivo = repositorio.findById(id);
        if(tipoDispositivo!=null){//comprobamos si el objeto existe
            repositorio.deleteById(id);
        }
        return tipoDispositivo;
    }
    
}
