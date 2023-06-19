
package com.seguridad.seguridad.dto;

import com.seguridad.seguridad.entities.Usuarios;


public class UsuarioComunidadAdd {
    
    private int idUsuario;
    private String codigoComunidad;
    private Usuarios usuario;

    public UsuarioComunidadAdd() {
    }

    public UsuarioComunidadAdd(int idUsuario, String codigoComunidad, Usuarios usuario) {
        this.idUsuario = idUsuario;
        this.codigoComunidad = codigoComunidad;
        this.usuario = usuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCodigoComunidad() {
        return codigoComunidad;
    }

    public void setCodigoComunidad(String codigoComunidad) {
        this.codigoComunidad = codigoComunidad;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
    
    
   
    
}
