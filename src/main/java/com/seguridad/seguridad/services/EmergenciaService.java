
package com.seguridad.seguridad.services;

import com.seguridad.seguridad.entities.Emergencia;
import java.util.List;
import java.util.Optional;

public interface EmergenciaService {
    
    Emergencia insertarEmergencia(Emergencia emergencia);

    List<Emergencia> listarEmergencias();

    Optional<Emergencia> listarEmergenciaID(int id);

    Emergencia editarEmergencia(Emergencia emergencia);

    Optional<Emergencia> eliminarEmergencia(int id);
    
}
