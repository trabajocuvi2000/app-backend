package com.seguridad.seguridad.controller;

import com.seguridad.seguridad.dao.DispositivoDao;
import com.seguridad.seguridad.entities.Comunidad;
import com.seguridad.seguridad.entities.Dispositivo;
import com.seguridad.seguridad.entities.Empleado;
import com.seguridad.seguridad.services.DispositivoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping({"dispositivos"})
public class DispositivoController {

    @Autowired
    private DispositivoService service;

    @Autowired
    private DispositivoDao dispositivoDao;

    // actualizar el estado del sispositivo de acuerdo a la emergencia reportada
    @PostMapping(path = {"/actualizarDispositivo/{id}"})
    public Optional<Dispositivo> actualizarEstadoDispositivo(@RequestBody Comunidad comunidad, @PathVariable("id") int id) {
//        return null;
        return dispositivoDao.actualizarEstadoDispositivo(id, comunidad);
    }

    @GetMapping
    public List<Dispositivo> listar() {
        return service.listarDispositivos();
    }

    @PostMapping
    public Dispositivo insertar(@RequestBody Dispositivo dispositivo) {
        return service.insertarDispositivo(dispositivo);
    }

    @GetMapping(path = {"/{id}"})
    public Optional<Dispositivo> listarUsuarioId(@PathVariable("id") int id) {
        return service.listarDispositivoID(id);
    }

    @PutMapping(path = {"/{id}"})
    public Dispositivo editarUsuarioIfon(@RequestBody Dispositivo dispositivo, @PathVariable("id") int id) {
        dispositivo.setDispositivo_id(id);
        return service.editarDispositivo(dispositivo);
    }

}
