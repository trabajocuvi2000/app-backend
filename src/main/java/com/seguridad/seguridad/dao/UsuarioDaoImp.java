package com.seguridad.seguridad.dao;

import com.seguridad.seguridad.dto.UsuarioComunidadAdd;
import com.seguridad.seguridad.entities.Comunidad;
import com.seguridad.seguridad.entities.Usuarios;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Usuarios obtenerUsuarioPorCredenciales(Usuarios usuario) {

        System.out.println(usuario.getCorreo_1());
        boolean valor = false;
        String query = "select u from Usuarios as u where u.correo_1 = :correo";
        List<Usuarios> lista = entityManager.createQuery(query).setParameter("correo", usuario.getCorreo_1()).getResultList();
//        SI LA LISTA ESTA VACIA NO SE ENCONTRO UN USUARIO CON EL CORREO
        if (lista.isEmpty()) {
            return null;
        }

        String passwordHashed = lista.get(0).getContrasena();
//        VERIFICAMOS SI LA CONTORASENA ES LA CORRECTA
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if (argon2.verify(passwordHashed, usuario.getContrasena())) {
            return lista.get(0); // DEVOLVEMOS EL USUARIO en caso de que el usuario y la contrasena sena las correctas
        } else {
            return null;
        }
    }

    // obtiene todos los usuarios que pertenencen a una comunidad por el id de la Comunidad
    @Override
    public List<Usuarios> obtenerUsuariosComunidad(int idComunidadUsuarioPertenence) {

        String query = "select u from Usuarios as u where u.comunidad.comunidad_id = :usuarioComunidadPerteneceId";
        List<Usuarios> listaUsuarios = entityManager.createQuery(query).setParameter("usuarioComunidadPerteneceId", idComunidadUsuarioPertenence).getResultList();

        if (listaUsuarios.isEmpty()) {
            return null;
        }

        return listaUsuarios;

    }

    @Override
    public UsuarioComunidadAdd actualizarComunidadUsuario(int usuarioId, String codigoComunidad) {
//        select comunidad_id FROM comunidad WHERE codigo = "";
        String query1 = "select c from Comunidad as c where c.codigo = :codigoComunidad";
        List<Comunidad> listaComunidad = entityManager.createQuery(query1).setParameter("codigoComunidad", codigoComunidad).getResultList();
        
        System.out.println(listaComunidad);
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuarios comprobarCorreoUsuario(Usuarios usuario) {
        String query = "select u from Usuarios as u where u.correo_1 = :correo";
        List<Usuarios> lista = entityManager.createQuery(query).setParameter("correo", usuario.getCorreo_1()).getResultList();
//        SI LA LISTA ESTA VACIA NO SE ENCONTRO UN USUARIO CON EL CORREO
        if (lista.isEmpty()) {
            return null;
        }
        return lista.get(0);
    }

    @Override
    public Usuarios recuperarContrasena(Usuarios usuario) {
        String query = "select u from Usuarios as u where u.correo_1 = :correo";
        List<Usuarios> lista = entityManager.createQuery(query).setParameter("correo", usuario.getCorreo_1()).getResultList();
//        SI LA LISTA ESTA VACIA NO SE ENCONTRO UN USUARIO CON EL CORREO
        if (lista.isEmpty()) {
            return null;
        }
        
        // actualizamos la contrasena del usuario
        int idUsuario = lista.get(0).getUsuario_id();
        String contrasena = "1234";
     
        //        ENCRIPTAMOS LA CONTRASENA
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, contrasena);
       
        Query querySt = null;
        String queryUpdate = "update Usuarios u set u.contrasena = :contrasena where u.usuario_id = :idUsuario";
        querySt = entityManager.createQuery(queryUpdate).setParameter("contrasena", hash).setParameter("idUsuario", idUsuario);
        int isRun = querySt.executeUpdate();
        // enviamos unmmens
//        System.out.println(isRun);
        // insertamos la contrqasen en el objeto para que debuelva
        lista.get(0).setContrasena(hash);
        return lista.get(0);
    }

}
