
package com.seguridad.seguridad.services;

import com.seguridad.seguridad.entities.Usuarios;
import com.seguridad.seguridad.repository.UsuarioRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImp implements UsuarioService{
    
    @Autowired
    private UsuarioRepo repositorio;

    @Override
    public Usuarios insertarUsuario(Usuarios p) {
        return repositorio.save(p);
    }

    @Override
    public List<Usuarios> listarUsuarios() {
        return repositorio.findAll();
    }

    @Override
    public Optional<Usuarios> listarID(int id) {
        return repositorio.findById(id);
    }

    @Override
    public Usuarios editar(Usuarios p) {
        return repositorio.save(p);
    }

    @Override
    public Optional<Usuarios> eliminar(int id) {
        Optional<Usuarios> p = repositorio.findById(id);
        if(p!=null){//comprobamos si el objeto existe
            repositorio.deleteById(id);
        }
        return p;
    }
    
}
