
package com.seguridad.seguridad.controller;

import com.seguridad.seguridad.entities.NivelEmergencia;
import com.seguridad.seguridad.services.NivelEmergenciaService;
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
@RequestMapping({"nivelemergencias"})
public class NivelEmergenciaController {
    
    @Autowired
    private NivelEmergenciaService service;
    
    @GetMapping
    public List<NivelEmergencia> listar(){
        return service.listarNivelEmergencias();
    }
    
    @PostMapping
    public NivelEmergencia insertar(@RequestBody NivelEmergencia nivelEmergencia){
        return service.insertarNivelEmergencia(nivelEmergencia);
    }
    
}
