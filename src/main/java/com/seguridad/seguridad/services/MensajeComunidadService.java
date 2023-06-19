/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.seguridad.seguridad.services;

import com.seguridad.seguridad.entities.MensajeComunidad;
import java.util.List;
import java.util.Optional;

public interface MensajeComunidadService {

    MensajeComunidad insertarMensajeComunidad(MensajeComunidad mensajeComunidad);

    List<MensajeComunidad> listarMensajesComunidad();

    Optional<MensajeComunidad> listarMensajeComunidadID(int id);

    MensajeComunidad editarMensajeComunidad(MensajeComunidad mensajeComunidad);

    Optional<MensajeComunidad> eliminarMensajeComunidad(int id);

}
