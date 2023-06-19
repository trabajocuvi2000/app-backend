package com.seguridad.seguridad.controller;

import com.seguridad.seguridad.dao.DispositivoUsuarioDao;
import com.seguridad.seguridad.entities.DispositivoUsuario;
import com.seguridad.seguridad.model.ConfirmChange;
import com.seguridad.seguridad.model.DispositivoUsuaioActualizado;
import com.seguridad.seguridad.services.DispositivoUsuarioService;
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
@RequestMapping({"dispositivousuario"})
public class DispositivoUsuarioController {

    @Autowired
    private DispositivoUsuarioService service;

    @Autowired
    private DispositivoUsuarioDao dispositivoUsuarioDao;

    @GetMapping
    public List<DispositivoUsuario> listar() {
        return service.listarDispositivosUsuario();
    }

    @PostMapping
    public DispositivoUsuario insertar(@RequestBody DispositivoUsuario dispositivoUsuario) {
        GeneradorCodigo g = new GeneradorCodigo();
        String codigo = g.generarCodigoJugador("D-U");
        dispositivoUsuario.setCodigo(codigo);
        // fecha
        FechaRegistro f = new FechaRegistro();
        dispositivoUsuario.setFechaCreacion(f.getFecha());
        dispositivoUsuario.setFechaModificacion(f.getFecha());
        return service.insertarDispositivoUsuario(dispositivoUsuario);
    }

    @GetMapping(path = {"/{id}"})
    public Optional<DispositivoUsuario> listarUsuarioId(@PathVariable("id") int id) {
        return service.listarDispositivioUsuarioId(id);
    }

    @PutMapping(path = {"/{id}"})
    public DispositivoUsuario editarUsuarioIfon(@RequestBody DispositivoUsuario dispositivoUsuario, @PathVariable("id") int id) {
        // fecha
        FechaRegistro f = new FechaRegistro();
        dispositivoUsuario.setFechaModificacion(f.getFecha());
        dispositivoUsuario.setDispositivoUsuario_id(id);
        return service.editarDispositivioUsuario(dispositivoUsuario);
    }

    @DeleteMapping(path = {"/{id}"})
    public Optional<DispositivoUsuario> eliminarEstandar(@PathVariable("id") int id) {
        return service.eliminarDispositivoUsuario(id);
    }

    @GetMapping(path = {"/usuario/{id}"})
    public List<DispositivoUsuario> listarDispositivosUsuario(@PathVariable("id") int id) {
        return dispositivoUsuarioDao.dispositivosUsuario(id);
    }

//     @PutMapping(path = {"/actualizarEstatus/{id}"})
//    public DispositivoUsuario editarEstatusDispositivoUsuario(@RequestBody DispositivoUsuario dispositivoUsuario, @PathVariable("id") int id) {
//        dispositivoUsuario.setIsActive(!dispositivoUsuario.isIsActive());
//        dispositivoUsuario.setDispositivoUsuario_id(id);
//        return service.editarDispositivioUsuario(dispositivoUsuario);
//    }
    @PutMapping(path = {"/actualizarEstatus/{id}"})
    public ConfirmChange editarEstatusDispositivoUsuario(@PathVariable("id") int id) {
        return dispositivoUsuarioDao.actualizarEstadoDispositivoUsuario(id);
    }
    
    @PostMapping(path = {"/actualizarEstadoDispositivoUsuario/{id}"})
    public DispositivoUsuaioActualizado listarActualizarDis(@RequestBody DispositivoUsuario dispositivoUsuario, @PathVariable("id") int id) {
        return dispositivoUsuarioDao.actualizarEstadoDispositivoUsuarioByDevice(id, dispositivoUsuario);
    }

}
