package com.seguridad.seguridad.dao;

import com.seguridad.seguridad.entities.DispositivoUsuario;
import com.seguridad.seguridad.model.ConfirmChange;
import com.seguridad.seguridad.model.DispositivoUsuaioActualizado;
import java.util.List;
import java.util.Optional;

public interface DispositivoUsuarioDao {

    List<DispositivoUsuario> dispositivosUsuario(int usuarioId);

    //actualizar el estado del dispositivo de activo a no activo
    ConfirmChange actualizarEstadoDispositivoUsuario(int dispositivoUsuarioId);

    // actualzar dispositivo
    DispositivoUsuaioActualizado actualizarEstadoDispositivoUsuarioByDevice(int dispositivoUsuarioId, DispositivoUsuario dispositivoUsuario);
}
