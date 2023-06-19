/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.seguridad.seguridad.dao;

import com.seguridad.seguridad.dto.UsuarioComunidadAdd;
import com.seguridad.seguridad.entities.Usuarios;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface UsuarioDao {

    Usuarios comprobarCorreoUsuario(Usuarios usuario);
    Usuarios obtenerUsuarioPorCredenciales(Usuarios usuario);
    List<Usuarios> obtenerUsuariosComunidad(int idComunidadUsuarioPertenence);
    UsuarioComunidadAdd actualizarComunidadUsuario(int usuarioId, String codigoComunidad); 
    Usuarios recuperarContrasena(Usuarios usuario);
    
}
