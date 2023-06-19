
package com.seguridad.seguridad.controller;

import com.seguridad.seguridad.dao.EmergenciaReportadaDao;
import com.seguridad.seguridad.entities.EmergenciaReportada;
import com.seguridad.seguridad.services.EmergenciaReportadaService;
import com.seguridad.seguridad.utils.FechaRegistro;
import com.seguridad.seguridad.utils.GeneradorCodigo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping({"emergencias/reportadas"})
public class EmergenciaReportadaController {
    
    @Autowired
    private EmergenciaReportadaService service;
    
    @Autowired
    private EmergenciaReportadaDao emergenciaReportadadDao;
    
    @GetMapping({"/ultimoelemento"})
    public EmergenciaReportada getLastElement(){
        return emergenciaReportadadDao.obtenerUltimaEmergenciaReportada();
    }
    
    @GetMapping
    public List<EmergenciaReportada> listar(){
        return service.listarEmergenciasReportadas();
    }
    
    @GetMapping(path = {"/{id}"})
    public Optional<EmergenciaReportada> listarUsuarioId(@PathVariable("id") int id) {
        return service.listarEmergenciaReportadaID(id);
    }
    
     @PostMapping
    public EmergenciaReportada insertar(@RequestBody EmergenciaReportada emergencia){
         GeneradorCodigo g = new GeneradorCodigo();
        String codigo = g.generarCodigoJugador("E-R");
        emergencia.setCodigo(codigo);
        // fecha
        FechaRegistro f = new FechaRegistro();
        emergencia.setFechaCreacion(f.getFecha());
        emergencia.setFechaModificacion(f.getFecha());
        return service.insertarEmergenciaReportada(emergencia);
    }
    
}
