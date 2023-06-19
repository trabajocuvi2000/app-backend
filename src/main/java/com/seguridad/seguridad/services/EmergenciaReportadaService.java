
package com.seguridad.seguridad.services;

import com.seguridad.seguridad.entities.EmergenciaReportada;
import java.util.List;
import java.util.Optional;


public interface EmergenciaReportadaService {
    
    EmergenciaReportada insertarEmergenciaReportada(EmergenciaReportada emergenciaReportada);

    List<EmergenciaReportada> listarEmergenciasReportadas();

    Optional<EmergenciaReportada> listarEmergenciaReportadaID(int id);

    EmergenciaReportada editarEmergenciaReportada(EmergenciaReportada emergenciaReportada);

    Optional<EmergenciaReportada> eliminarEmergenciaReportada(int id);
    
}
