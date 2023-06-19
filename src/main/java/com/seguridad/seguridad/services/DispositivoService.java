
package com.seguridad.seguridad.services;

import com.seguridad.seguridad.entities.Dispositivo;
import java.util.List;
import java.util.Optional;

public interface DispositivoService {
    
    Dispositivo insertarDispositivo(Dispositivo dispositivo);

    List<Dispositivo> listarDispositivos();

    Optional<Dispositivo> listarDispositivoID(int id);

    Dispositivo editarDispositivo(Dispositivo dispositivo);

    Optional<Dispositivo> eliminarDispositivo(int id);
}
