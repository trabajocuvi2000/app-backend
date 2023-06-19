
package com.seguridad.seguridad.services;

import com.seguridad.seguridad.entities.Dis;
import java.util.List;
import java.util.Optional;

public interface DisService {

    Dis insertarDispositivo(Dis dis);

    List<Dis> listarDispositivos();
    
    
    Optional<Dis> listarComunidadID(int id);

    Dis editarComunidad(Dis comunidad);

    Optional<Dis> eliminarComunidad(int id);

}
