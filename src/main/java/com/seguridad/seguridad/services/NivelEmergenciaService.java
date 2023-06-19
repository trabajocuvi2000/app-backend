package com.seguridad.seguridad.services;

import com.seguridad.seguridad.entities.NivelEmergencia;
import java.util.List;
import java.util.Optional;

public interface NivelEmergenciaService {

    NivelEmergencia insertarNivelEmergencia(NivelEmergencia nivelEmergencia);

    List<NivelEmergencia> listarNivelEmergencias();

    Optional<NivelEmergencia> listarNivelEmegenciaID(int id);

    NivelEmergencia editarNivelEmergencia(NivelEmergencia nivelEmergencia);

    Optional<NivelEmergencia> eliminarNivelEmergencia(int id);

}
