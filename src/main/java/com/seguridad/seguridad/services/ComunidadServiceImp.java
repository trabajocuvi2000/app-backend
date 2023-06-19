package com.seguridad.seguridad.services;

import com.seguridad.seguridad.entities.Comunidad;
import com.seguridad.seguridad.repository.ComunidadRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComunidadServiceImp implements ComunidadService {

    @Autowired
    private ComunidadRepo repositorio;

    @Override
    public Comunidad insertarComuidad(Comunidad comunidad) {
        return repositorio.save(comunidad);
    }

    @Override
    public List<Comunidad> listarComunidades() {
        return repositorio.findAll();
    }

    @Override
    public Optional<Comunidad> listarComunidadID(int id) {
        return repositorio.findById(id);
    }

    @Override
    public Comunidad editarComunidad(Comunidad comunidad) {
        return repositorio.save(comunidad);
    }

    @Override
    public boolean eliminarComunidad(int id) {
        Optional<Comunidad> comunidad = repositorio.findById(id);
        if (comunidad != null) {//comprobamos si el objeto existe
            try {
                repositorio.deleteById(id);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

}
