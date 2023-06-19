
package com.seguridad.seguridad.dao;

import com.seguridad.seguridad.entities.MensajeComunidad;
import java.util.List;

public interface MensajeComunidadDao {
    
    List<MensajeComunidad> getMesnajesComunidad(int comunidadId);
    
}
