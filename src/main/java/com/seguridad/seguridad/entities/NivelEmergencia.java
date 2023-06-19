
package com.seguridad.seguridad.entities;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "nivel_emergencia")
public class NivelEmergencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nivelEmergencia_id;
    private int nivelEmergencia;
    private String codigo;
    private String nombre;
    @Column(length = 5000)
    private String descripcion;
    private Date fechaCreacion;
    private Date FechaModificacion;
    
//    RELACION CON EMERGENCIA
//    @OneToMany
//    @JoinColumn(name = "emergencia_id")
//    private List<Emergencia> emergencias;

    public int getNivelEmergencia_id() {
        return nivelEmergencia_id;
    }

    public void setNivelEmergencia_id(int nivelEmergencia_id) {
        this.nivelEmergencia_id = nivelEmergencia_id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public int getNivelEmergencia() {
        return nivelEmergencia;
    }

    public void setNivelEmergencia(int nivelEmergencia) {
        this.nivelEmergencia = nivelEmergencia;
    }
    
    
}
