package com.seguridad.seguridad.controller;

import com.seguridad.seguridad.dao.UsuarioDao;
import com.seguridad.seguridad.entities.Usuarios;
import com.seguridad.seguridad.utils.JWTUtil;
import com.seguridad.seguridad.dto.UsuarioToken;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin
@RestController
@RequestMapping({"/user"})
public class AuthController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    @PersistenceContext
    EntityManager entityManager;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public UsuarioToken login(@RequestBody Usuarios usuario) {
        UsuarioToken usuarioToken = new UsuarioToken();

        Usuarios usuarioLogueado = usuarioDao.obtenerUsuarioPorCredenciales(usuario);
        if (usuarioLogueado != null) {
//            CREAMOS  EL TOKEN
            String tokenJwt = jwtUtil.create(String.valueOf(usuarioLogueado.getUsuario_id()), usuarioLogueado.getCorreo_1());
//CREAMOS EL OBJETO QUE SE ENVIA COMO RESPUESTA CUANDO EL USUARIOSESTA LOGEAGO
            usuarioToken.setUsuario(usuarioLogueado);
            usuarioToken.setToken(tokenJwt);
            usuarioToken.setIsLogin(true);
            return usuarioToken;
        }

        usuarioToken.setUsuario(null);
        usuarioToken.setToken("No esta autentificado");
        usuarioToken.setIsLogin(false);
        return usuarioToken;
    }
    
     @RequestMapping(value = "/recuperarConrasena", method = RequestMethod.POST)
    public Usuarios recuperarContrasena(@RequestBody Usuarios usuario) {
        return usuarioDao.recuperarContrasena(usuario);
    }
    
    @RequestMapping(value = "/actualizarContrasena/{nuevaContrasena}", method = RequestMethod.POST)
    public Usuarios actualizarContrasena(@RequestBody Usuarios usuario, @PathVariable("nuevaContrasena") String nuevaContrasena) {
        return usuarioDao.actualizarContrasena(usuario, nuevaContrasena);
    }

}
