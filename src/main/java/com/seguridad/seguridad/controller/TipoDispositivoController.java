package com.seguridad.seguridad.controller;

import com.seguridad.seguridad.entities.TipoDispositivo;
import com.seguridad.seguridad.services.TipoDispositivoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping({"tipodispositivo"})
public class TipoDispositivoController {

    @Autowired
    private TipoDispositivoService service;

    @GetMapping
    public List<TipoDispositivo> listar() {
        return service.listarTiposDispositivos();
    }

    @PostMapping
    public TipoDispositivo insertar(@RequestBody TipoDispositivo tipoDispositivo) {
        return service.insertarTipoDispositivo(tipoDispositivo);
    }

}
