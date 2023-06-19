
package com.seguridad.seguridad.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DispositivoUsuarioMensaje {
    
    private boolean isActive;
    private String nombre;
    private int DispositivoId;
    private String mensaje;
    private boolean isUpdate;
    
}
