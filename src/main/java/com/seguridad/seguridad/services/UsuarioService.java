
package com.seguridad.seguridad.services;

import com.seguridad.seguridad.entities.Usuarios;
import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    Usuarios insertarUsuario(Usuarios p);

    List<Usuarios> listarUsuarios();

    Optional<Usuarios> listarID(int id);

    Usuarios editar(Usuarios p);

    Optional<Usuarios> eliminar(int id);

}
