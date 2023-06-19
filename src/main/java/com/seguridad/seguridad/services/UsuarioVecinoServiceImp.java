
package com.seguridad.seguridad.services;

import com.seguridad.seguridad.entities.UsuarioVecino;
import com.seguridad.seguridad.repository.UsuarioVecinoRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioVecinoServiceImp implements UsuarioVecinoService{
    
    @Autowired
    private UsuarioVecinoRepo repositorio;

    @Override
    public UsuarioVecino insertarUsuario(UsuarioVecino usuarioVecino) {
        return  repositorio.save(usuarioVecino);
    }

    @Override
    public List<UsuarioVecino> listarUsuarios() {
        return repositorio.findAll();
    }

    @Override
    public Optional<UsuarioVecino> listarID(int id) {
        return repositorio.findById(id);
    }

    @Override
    public UsuarioVecino editar(UsuarioVecino usuarioVecino) {
        return repositorio.save(usuarioVecino);
    }

    @Override
    public Optional<UsuarioVecino> eliminar(int id) {
        Optional<UsuarioVecino> usuarioVecino = repositorio.findById(id);
        if(usuarioVecino!=null){//comprobamos si el objeto existe
            repositorio.deleteById(id);
        }
        return usuarioVecino;
    }
    
    
    
}
