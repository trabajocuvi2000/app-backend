
package com.seguridad.seguridad.controller;

import com.seguridad.seguridad.entities.Emergencia;
import com.seguridad.seguridad.services.EmergenciaService;
import com.seguridad.seguridad.utils.FechaRegistro;
import com.seguridad.seguridad.utils.GeneradorCodigo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping({"emergencias"})
public class EmergenciaController {
    
    @Autowired
    private EmergenciaService service;
    
    @GetMapping
    public List<Emergencia> listar(){
        return service.listarEmergencias();
    }
    
     @PostMapping
    public Emergencia insertar(@RequestBody Emergencia emergencia){
         GeneradorCodigo g = new GeneradorCodigo();
        String codigo = g.generarCodigoJugador("E");
        emergencia.setCodigo(codigo);
        // fecha
        FechaRegistro f = new FechaRegistro();
        emergencia.setFechaCreacion(f.getFecha());
        emergencia.setFechaModificacion(f.getFecha());
        return service.insertarEmergencia(emergencia);
    }
    
    @GetMapping(path = {"/{id}"})
    public Optional<Emergencia> listarEmergenciaId(@PathVariable("id") int id) {
        return service.listarEmergenciaID(id);
    }
    
    @PutMapping(path = {"/{id}"})
    public Emergencia editarEmergenciaIfon(@RequestBody Emergencia emergencia, @PathVariable("id") int id) {
        // insertyamos la fecha de actualizacion 
        FechaRegistro f = new FechaRegistro();
        emergencia.setFechaModificacion(f.getFecha());
        emergencia.setEmergencia_id(id);
        return service.editarEmergencia(emergencia);
    }
    
    @DeleteMapping(path = {"/{id}"})
    public Optional<Emergencia> eliminarComunidad(@PathVariable("id") int id) {
        return service.eliminarEmergencia(id);
    }
    
}
