
package com.seguridad.seguridad.dao;

import com.seguridad.seguridad.entities.Dis;
import java.util.Optional;

public interface DistDao{
    
     //actualizar el estado del dispositivo de activo a no activo
    // pero tiene que recivir el cuerpo del dist
     boolean actualizarEstadoDist(int comunidadId, Dis dist);

    
}
