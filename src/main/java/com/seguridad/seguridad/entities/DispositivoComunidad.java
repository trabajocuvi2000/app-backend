
package com.seguridad.seguridad.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dispositivo_comunidad")
public class DispositivoComunidad {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dispositivoComunidad_Id;
    private String nombre;
    private String codigo;
    private String descripcion;
    private boolean isActive;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private int nivel_emergencia;
    
    @ManyToOne
    @JoinColumn(name = "comunidad_id")
    private Comunidad comunidad;

    public int getDispositivoComunidad_Id() {
        return dispositivoComunidad_Id;
    }

    public void setDispositivoComunidad_Id(int dispositivoComunidad_Id) {
        this.dispositivoComunidad_Id = dispositivoComunidad_Id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Comunidad getComunidad() {
        return comunidad;
    }

    public void setComunidad(Comunidad comunidad) {
        this.comunidad = comunidad;
    }

    public int getNivel_emergencia() {
        return nivel_emergencia;
    }

    public void setNivel_emergencia(int nivel_emergencia) {
        this.nivel_emergencia = nivel_emergencia;
    }
    
    
    
    
    
}
