/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.seguridad.seguridad.controller;

import com.seguridad.seguridad.entities.UsuarioVecino;
import com.seguridad.seguridad.services.UsuarioVecinoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping({"usuariovecino"})
public class UsuariosVecinoController {

    @Autowired
    private UsuarioVecinoService service;

    @GetMapping
    public List<UsuarioVecino> listarUsuariosVecinos() {
        return service.listarUsuarios();
    }

    @PostMapping
    public UsuarioVecino insertarUsuarioVecino(@RequestBody UsuarioVecino usuarioVecino) {
        return service.insertarUsuario(usuarioVecino);
    }

    @PutMapping(path = {"/{id}"})
    public UsuarioVecino editarUsuarioIfon(@RequestBody UsuarioVecino usuarioVecino, @PathVariable("id") int id) {
        usuarioVecino.setUsuarioVecino_id(id);
        return service.editar(usuarioVecino);
    }

}
