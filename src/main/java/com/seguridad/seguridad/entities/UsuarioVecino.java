
package com.seguridad.seguridad.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios_vecinos")
public class UsuarioVecino {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int usuarioVecino_id;
    private String nombre;
    private String apellido;
    private Integer telefono_1;
    private Integer telefono_2;
    private String direccion;
    private String ubicacionCasa;
    private String codigo;
    private Date fechaCreacion;
    private Date FechaModificacion;

    public int getUsuarioVecino_id() {
        return usuarioVecino_id;
    }

    public void setUsuarioVecino_id(int usuarioVecino_id) {
        this.usuarioVecino_id = usuarioVecino_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getTelefono_1() {
        return telefono_1;
    }

    public void setTelefono_1(Integer telefono_1) {
        this.telefono_1 = telefono_1;
    }

    public Integer getTelefono_2() {
        return telefono_2;
    }

    public void setTelefono_2(Integer telefono_2) {
        this.telefono_2 = telefono_2;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUbicacionCasa() {
        return ubicacionCasa;
    }

    public void setUbicacionCasa(String ubicacionCasa) {
        this.ubicacionCasa = ubicacionCasa;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return FechaModificacion;
    }

    public void setFechaModificacion(Date FechaModificacion) {
        this.FechaModificacion = FechaModificacion;
    }
    
    
    
}
