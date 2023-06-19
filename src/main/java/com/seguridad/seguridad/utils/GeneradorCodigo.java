
package com.seguridad.seguridad.utils;

import java.util.UUID;


public class GeneradorCodigo {

    public String generarCodigoJugador(String caracter) {
        UUID uuid = UUID.randomUUID();
        return caracter +"-"+ uuid.toString();
    }

}
