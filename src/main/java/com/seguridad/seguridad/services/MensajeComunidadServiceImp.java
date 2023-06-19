package com.seguridad.seguridad.services;

import com.seguridad.seguridad.entities.MensajeComunidad;
import com.seguridad.seguridad.repository.MensajeComunidadRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MensajeComunidadServiceImp implements MensajeComunidadService {

    @Autowired
    private MensajeComunidadRepo repositorio;

    @Override
    public MensajeComunidad insertarMensajeComunidad(MensajeComunidad mensajeComunidad) {
        return repositorio.save(mensajeComunidad);
    }

    @Override
    public List<MensajeComunidad> listarMensajesComunidad() {
        return repositorio.findAll();
    }

    @Override
    public Optional<MensajeComunidad> listarMensajeComunidadID(int id) {
        return repositorio.findById(id);
    }

    @Override
    public MensajeComunidad editarMensajeComunidad(MensajeComunidad mensajeComunidad) {
        return  repositorio.save(mensajeComunidad);
    }

    @Override
    public Optional<MensajeComunidad> eliminarMensajeComunidad(int id) {
        Optional<MensajeComunidad> mensajeComunidad = repositorio.findById(id);
        if(mensajeComunidad!=null){//comprobamos si el objeto existe
            repositorio.deleteById(id);
        }
        return mensajeComunidad;
    }

}
