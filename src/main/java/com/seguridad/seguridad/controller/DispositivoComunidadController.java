package com.seguridad.seguridad.controller;

import com.seguridad.seguridad.dao.DispositivoComunidadDao;
import com.seguridad.seguridad.entities.DispositivoComunidad;
import com.seguridad.seguridad.entities.Emergencia;
import com.seguridad.seguridad.services.DispositivoComunidadService;
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
@RequestMapping({"dispositivocomunidad"})
public class DispositivoComunidadController {

    @Autowired
    private DispositivoComunidadService service;

    @Autowired
    private DispositivoComunidadDao dispositivicoComunidadDao;

    @GetMapping
    public List<DispositivoComunidad> listar() {
        return service.listarDispositivosComunidad();
    }

    @PostMapping
    public DispositivoComunidad insertar(@RequestBody DispositivoComunidad dispositivoComunidad) {
        GeneradorCodigo g = new GeneradorCodigo();
        String codigo = g.generarCodigoJugador("D-C");
        dispositivoComunidad.setCodigo(codigo);
        // ingresamos la fecha
        FechaRegistro f = new FechaRegistro();
        dispositivoComunidad.setFechaCreacion(f.getFecha());
        dispositivoComunidad.setFechaModificacion(f.getFecha());
        return service.insertarDispositivoComunidad(dispositivoComunidad);
    }

    @GetMapping(path = {"/{id}"})
    public Optional<DispositivoComunidad> listarUsuarioId(@PathVariable("id") int id) {
        return service.listarDispositivosComunidadId(id);
    }

    @PutMapping(path = {"/{id}"})
    public DispositivoComunidad editarUsuarioIfon(@RequestBody DispositivoComunidad dispositivoComunidad, @PathVariable("id") int id) {
        ///ingresamo sla fecha de modificacion 
        FechaRegistro f = new FechaRegistro();
        dispositivoComunidad.setFechaModificacion(f.getFecha());
        dispositivoComunidad.setDispositivoComunidad_Id(id);
        return service.editarDispositivoComunidad(dispositivoComunidad);
    }

    @DeleteMapping(path = {"/{id}"})
    public Optional<DispositivoComunidad> eliminarEstandar(@PathVariable("id") int id) {
        return service.eliminarDispositivoComunidad(id);
    }

    @GetMapping(path = {"/listadispositivos/{id}"})
    public List<DispositivoComunidad> listarDispositivosComunidad(@PathVariable("id") int id) {
        return dispositivicoComunidadDao.dispositivosComunidad(id);
    }
    
     @PostMapping(path = {"/actualizarEstadoDispositivoComunidad/{id}"})
    public Optional<DispositivoComunidad> actualizarEstadoDispositivo(@RequestBody Emergencia emergencia, @PathVariable("id") int id) {
//        return null;
        return dispositivicoComunidadDao.actualizarEstadoDispositivo(id, emergencia);
    }
}
