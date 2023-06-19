package com.seguridad.seguridad.controller;

import com.seguridad.seguridad.dao.MensajeComunidadDao;
import com.seguridad.seguridad.entities.MensajeComunidad;
import com.seguridad.seguridad.services.MensajeComunidadService;
import com.seguridad.seguridad.utils.FechaRegistro;
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
@RequestMapping({"mensaejesComunidad"})
public class MensajesComunidadController {

    @Autowired
    private MensajeComunidadService service;

    @Autowired
    private MensajeComunidadDao mesnajesComunidadDao;

    @GetMapping
    public List<MensajeComunidad> listarMensjesComunidad() {
        return service.listarMensajesComunidad();
    }

    @PostMapping
    public MensajeComunidad guardarMensajesComunidad(@RequestBody MensajeComunidad mensajeComunidad) {

        FechaRegistro f = new FechaRegistro();
        mensajeComunidad.setDate(f.getFecha());
        return service.insertarMensajeComunidad(mensajeComunidad);
        
    }

    @GetMapping(path = {"/{id}"})
    public Optional<MensajeComunidad> listarMensajeComunidadId(@PathVariable("id") int id) {
        return service.listarMensajeComunidadID(id);
    }

    @PutMapping(path = {"/{id}"})
    public MensajeComunidad editarUsuarioIfon(@RequestBody MensajeComunidad mensajeComunidad, @PathVariable("id") int id) {
        mensajeComunidad.setMensajes_comunidad_id(id);
        return service.editarMensajeComunidad(mensajeComunidad);
    }

    @DeleteMapping(path = {"/{id}"})
    public Optional<MensajeComunidad> eliminarMensajeComunidad(@PathVariable("id") int id) {
        return service.eliminarMensajeComunidad(id);
    }

    @GetMapping(path = {"/mensajes/{id}"})
    public List<MensajeComunidad> listarMesanjesComunidadByIdComunidad(@PathVariable("id") int id) {
        return mesnajesComunidadDao.getMesnajesComunidad(id);
    }
}
