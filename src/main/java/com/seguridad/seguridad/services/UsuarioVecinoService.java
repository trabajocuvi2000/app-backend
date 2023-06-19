
package com.seguridad.seguridad.services;

import com.seguridad.seguridad.entities.UsuarioVecino;
import java.util.List;
import java.util.Optional;

public interface UsuarioVecinoService {
    
    UsuarioVecino insertarUsuario(UsuarioVecino usuarioVecino);

    List<UsuarioVecino> listarUsuarios();

    Optional<UsuarioVecino> listarID(int id);

    UsuarioVecino editar(UsuarioVecino usuarioVecino);

    Optional<UsuarioVecino> eliminar(int id);
    
}
