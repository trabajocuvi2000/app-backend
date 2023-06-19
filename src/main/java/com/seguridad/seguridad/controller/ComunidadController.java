package com.seguridad.seguridad.controller;

import com.seguridad.seguridad.entities.Comunidad;
import com.seguridad.seguridad.services.ComunidadService;
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
@RequestMapping({"comunidades"})
public class ComunidadController {

    @Autowired
    private ComunidadService service;

    @GetMapping
    public List<Comunidad> listar() {
        return service.listarComunidades();
    }

    @GetMapping(path = {"/{id}"})
    public Optional<Comunidad> listarUsuarioId(@PathVariable("id") int id) {
        return service.listarComunidadID(id);
    }

    @PostMapping
    public Comunidad insertar(@RequestBody Comunidad comunidad) {
        GeneradorCodigo g = new GeneradorCodigo();
        String codigo = g.generarCodigoJugador("C");
        comunidad.setCodigo(codigo);

        // insertamos las fechas
        FechaRegistro f = new FechaRegistro();
        comunidad.setFechaCreacion(f.getFecha());
        comunidad.setFechaModificacion(f.getFecha());
        return service.insertarComuidad(comunidad);
    }
    
    @PutMapping(path = {"/{id}"})
    public Comunidad editarUsuarioIfon(@RequestBody Comunidad comunidad, @PathVariable("id") int id) {
        // insertyamos la fecha de actualizacion 
        FechaRegistro f = new FechaRegistro();
        comunidad.setFechaModificacion(f.getFecha());
        comunidad.setComunidad_id(id);
        return service.editarComunidad(comunidad);
    }

    @DeleteMapping(path = {"/{id}"})
    public boolean eliminarComunidad(@PathVariable("id") int id) {
        return service.eliminarComunidad(id);
    }
}
