
package com.seguridad.seguridad.services;

import com.seguridad.seguridad.entities.DispositivoUsuario;
import java.util.List;
import java.util.Optional;

public interface DispositivoUsuarioService {
    
     DispositivoUsuario insertarDispositivoUsuario(DispositivoUsuario dispositivoUsuario);

    List<DispositivoUsuario> listarDispositivosUsuario();

    Optional<DispositivoUsuario> listarDispositivioUsuarioId(int id);

    DispositivoUsuario editarDispositivioUsuario(DispositivoUsuario dispositivoUsuario);

    Optional<DispositivoUsuario> eliminarDispositivoUsuario(int id);
}
