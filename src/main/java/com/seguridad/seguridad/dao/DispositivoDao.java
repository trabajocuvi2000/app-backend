
package com.seguridad.seguridad.dao;

import com.seguridad.seguridad.entities.Comunidad;
import com.seguridad.seguridad.entities.Dispositivo;
import java.util.Optional;


public interface DispositivoDao {
    
    Optional<Dispositivo> actualizarEstadoDispositivo(int emergenciaID, Comunidad comunidad);
    
}
