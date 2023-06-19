
package com.seguridad.seguridad.services;

import com.seguridad.seguridad.entities.TipoDispositivo;
import java.util.List;
import java.util.Optional;


public interface TipoDispositivoService {
    
    TipoDispositivo insertarTipoDispositivo(TipoDispositivo tipodDispositivo);

    List<TipoDispositivo> listarTiposDispositivos();

    Optional<TipoDispositivo> listarTipoDispositivoID(int id);

    TipoDispositivo editarTipoDispositivo(TipoDispositivo tipodDispositivo);

    Optional<TipoDispositivo> eliminarTipoDispositivo(int id);
    
    
}
