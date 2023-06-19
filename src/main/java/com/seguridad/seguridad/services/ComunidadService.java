
package com.seguridad.seguridad.services;

import com.seguridad.seguridad.entities.Comunidad;
import java.util.List;
import java.util.Optional;


public interface ComunidadService {
    
    Comunidad insertarComuidad(Comunidad comunidad);

    List<Comunidad> listarComunidades();

    Optional<Comunidad> listarComunidadID(int id);

    Comunidad editarComunidad(Comunidad comunidad);

    boolean eliminarComunidad(int id);
    
}
