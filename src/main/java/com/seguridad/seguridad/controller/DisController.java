/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguridad.seguridad.controller;

import com.seguridad.seguridad.dao.DistDao;
import com.seguridad.seguridad.entities.Dis;
import com.seguridad.seguridad.services.DisService;
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
@RequestMapping({"dis/xml"})
public class DisController {

    @Autowired
    private DisService service;
    
    @Autowired
    private DistDao dirtDao;

    @PostMapping
    public Dis guardarDispositivo(@RequestBody Dis dispositivo) {
        return service.insertarDispositivo(dispositivo);
    }

    @GetMapping
    public List<Dis> listar() {
        return service.listarDispositivos();
    }
    
    @GetMapping(path = {"/{id}"})
    public Optional<Dis> listarUsuarioId(@PathVariable("id") int id) {
        return service.listarComunidadID(id);
    }
    
    @PutMapping(path = {"/{id}"})
    public Dis editarUsuarioIfon(@RequestBody Dis dis, @PathVariable("id") int id) {
        dis.setId(id);
        return service.editarComunidad(dis);
    }
    
    @DeleteMapping(path = {"/{id}"})
    public Optional<Dis> eliminarEstandar(@PathVariable("id") int id) {
        return service.eliminarComunidad(id);
    }
    
    
    @PostMapping(path = {"/actualizarDis/{id}"})
    public boolean listarActualizarDis(@RequestBody Dis dis, @PathVariable("id") int id) {
        
        return dirtDao.actualizarEstadoDist(id, dis);
    }
}
