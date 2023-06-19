package com.seguridad.seguridad.dao;

import com.seguridad.seguridad.entities.DispositivoComunidad;
import com.seguridad.seguridad.entities.Emergencia;
import java.util.List;
import java.util.Optional;

public interface DispositivoComunidadDao {
//    obtenemos todos los dispositivos que tiene una comunidad
    List<DispositivoComunidad> dispositivosComunidad(int comunidaddId);
    //actualizar el estado del dispositivo de activo a no activo
     Optional<DispositivoComunidad> actualizarEstadoDispositivo(int comunidadId, Emergencia emergencia);

}
