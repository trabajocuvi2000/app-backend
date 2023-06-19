package com.seguridad.seguridad.controller;

import com.seguridad.seguridad.dao.ComunidadDao;
import com.seguridad.seguridad.dao.UsuarioDao;
import com.seguridad.seguridad.entities.Comunidad;
import com.seguridad.seguridad.entities.Usuarios;
import com.seguridad.seguridad.services.UsuarioService;
import com.seguridad.seguridad.utils.FechaRegistro;
import com.seguridad.seguridad.utils.GeneradorCodigo;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping({"usuarios"})
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private ComunidadDao comunidadDao;

    @GetMapping
    public List<Usuarios> listar() {
        return service.listarUsuarios();
    }

    @PostMapping
    public Usuarios insertar(@RequestBody Usuarios usuarrio) {
        // ingresamos el codigo
        GeneradorCodigo g = new GeneradorCodigo();
        String codigo = g.generarCodigoJugador("U");
        usuarrio.getUsuarioVecino().setCodigo(codigo);
        
        // ingresamos las fechas
        FechaRegistro f = new FechaRegistro();
        usuarrio.getUsuarioVecino().setFechaCreacion(f.getFecha());
        usuarrio.getUsuarioVecino().setFechaModificacion(f.getFecha());
//        ENCRIPTAMOS LA CONTRASENA
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, usuarrio.getContrasena());
//        GUARDAMOS LA CONTRASENA ENCRIPTADA
        usuarrio.setContrasena(hash);

//        en caso de que sea null quiere decir que el correo no se encuentra registrado
        if (usuarioDao.comprobarCorreoUsuario(usuarrio) == null) {
            return service.insertarUsuario(usuarrio);
        } else {
            System.out.println("EL CORREO YA SE ECUENTAR REGISTRADO");
            return null;
        }

    }

    @GetMapping(path = {"/{id}"})
    public Optional<Usuarios> listarUsuarioId(@PathVariable("id") int id) {
        return service.listarID(id);
    }

    @GetMapping(path = {"/comunidadusers/{id}"})
    public List<Usuarios> listarUsuariosComunidad(@PathVariable("id") int id) {
        return usuarioDao.obtenerUsuariosComunidad(id);
    }

    @PutMapping(path = {"/{id}"})
    public Usuarios editarUsuarioIfon(@RequestBody Usuarios usuario, @PathVariable("id") int id) {
       // ingresamos las fechas
        FechaRegistro f = new FechaRegistro();
        usuario.getUsuarioVecino().setFechaModificacion(f.getFecha());
        usuario.setUsuario_id(id);
        return service.editar(usuario);
    }

    @DeleteMapping(path = {"/{id}"})
    public Optional<Usuarios> eliminarEstandar(@PathVariable("id") int id) {
        return service.eliminar(id);
    }

    @PostMapping(path = {"/actualizarusuariocomunidad/{codigo}"})
    public Usuarios actualizarUsuarioComunidad(@RequestBody Usuarios usuario, @PathVariable("codigo") String codigo) {
        //obetnemos el id de la comunida dor su codigo
        Comunidad comunidad = comunidadDao.getIdComunidadByCodigo(codigo);
        if (comunidad != null) {
            usuario.setComunidad(comunidad);
            usuario.setUsuario_id(usuario.getUsuario_id());
            return service.editar(usuario);
        } else {
            System.out.println("El codigo ingresado no se encentra registrado en ninguna comunnidad");
        }
        return usuario;
        
    }
}
