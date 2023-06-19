
package com.seguridad.seguridad.services;

import com.seguridad.seguridad.entities.DispositivoComunidad;
import java.util.List;
import java.util.Optional;

public interface DispositivoComunidadService {
 
    DispositivoComunidad insertarDispositivoComunidad(DispositivoComunidad dispositivoComunidad);

    List<DispositivoComunidad> listarDispositivosComunidad();

    Optional<DispositivoComunidad> listarDispositivosComunidadId(int id);

    DispositivoComunidad editarDispositivoComunidad(DispositivoComunidad dispositivoComunidad);

    Optional<DispositivoComunidad> eliminarDispositivoComunidad(int id);
}
