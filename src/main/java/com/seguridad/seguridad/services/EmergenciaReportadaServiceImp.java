package com.seguridad.seguridad.services;

import com.seguridad.seguridad.entities.EmergenciaReportada;
import com.seguridad.seguridad.repository.EmergenciaReportadaRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmergenciaReportadaServiceImp implements EmergenciaReportadaService {

    @Autowired
    private EmergenciaReportadaRepo repositorio;

    @Override
    public EmergenciaReportada insertarEmergenciaReportada(EmergenciaReportada emergenciaReportada) {
        return repositorio.save(emergenciaReportada);
    }

    @Override
    public List<EmergenciaReportada> listarEmergenciasReportadas() {
        return repositorio.findAll();
    }

    @Override
    public Optional<EmergenciaReportada> listarEmergenciaReportadaID(int id) {
        return repositorio.findById(id);
    }

    @Override
    public EmergenciaReportada editarEmergenciaReportada(EmergenciaReportada emergenciaReportada) {
        return repositorio.save(emergenciaReportada);
    }

    @Override
    public Optional<EmergenciaReportada> eliminarEmergenciaReportada(int id) {
        Optional<EmergenciaReportada> emergenciaReportada = repositorio.findById(id);
        if (emergenciaReportada != null) {//comprobamos si el objeto existe
            repositorio.deleteById(id);
        }
        return emergenciaReportada;
    }

}
