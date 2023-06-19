package com.seguridad.seguridad.services;

import com.seguridad.seguridad.entities.DispositivoUsuario;
import com.seguridad.seguridad.repository.DispositivoUsuarioRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DispositivoUsuarioServiceImp implements DispositivoUsuarioService {

    @Autowired
    private DispositivoUsuarioRepo repositorio;

    @Override
    public DispositivoUsuario insertarDispositivoUsuario(DispositivoUsuario dispositivoUsuario) {
        return repositorio.save(dispositivoUsuario);
    }

    @Override
    public List<DispositivoUsuario> listarDispositivosUsuario() {
        return repositorio.findAll();
    }

    @Override
    public Optional<DispositivoUsuario> listarDispositivioUsuarioId(int id) {
        return repositorio.findById(id);
    }

    @Override
    public DispositivoUsuario editarDispositivioUsuario(DispositivoUsuario dispositivoUsuario) {
        return repositorio.save(dispositivoUsuario);
    }

    @Override
    public Optional<DispositivoUsuario> eliminarDispositivoUsuario(int id) {
        Optional<DispositivoUsuario> dispositivoUsuario = repositorio.findById(id);
        if(dispositivoUsuario!=null){//comprobamos si el objeto existe
            repositorio.deleteById(id);
        }
        return dispositivoUsuario;
    }

}
