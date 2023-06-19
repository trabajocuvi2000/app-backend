package com.seguridad.seguridad.entities;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "emergencia")
public class Emergencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int emergencia_id;
    private String codigo;
    private String nombre;
    @Column(length = 5000)
    private String descripcion;
    private double tiempoActivacion;
    private Date fechaCreacion;
    private Date FechaModificacion;
    private int nivel_emergencia;

//    RELACION CON NIVEL EMERGENCIA
    @ManyToOne
    @JoinColumn(name = "nivelEmergencia_id")
    private NivelEmergencia nivelEmergencia;
    
//    RELACION TIPO EMERGENCIA
    @ManyToOne
    @JoinColumn(name = "tipoEmergencia_id")
    private TipoEmergencia tipoEmergencia;
    
//    RELACION CON COMUNIDAD
//    @ManyToMany
//    @JoinColumn(name = "comunidad_id")
//    private List<Comunidad> comunidades;

    public double getTiempoActivacion() {
        return tiempoActivacion;
    }

    public void setTiempoActivacion(double tiempoActivacion) {
        this.tiempoActivacion = tiempoActivacion;
    }

    
    public int getEmergencia_id() {
        return emergencia_id;
    }

    public void setEmergencia_id(int emergencia_id) {
        this.emergencia_id = emergencia_id;
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

    public NivelEmergencia getNivelEmergencia() {
        return nivelEmergencia;
    }

    public void setNivelEmergencia(NivelEmergencia nivelEmergencia) {
        this.nivelEmergencia = nivelEmergencia;
    }

    public TipoEmergencia getTipoEmergencia() {
        return tipoEmergencia;
    }

    public void setTipoEmergencia(TipoEmergencia tipoEmergencia) {
        this.tipoEmergencia = tipoEmergencia;
    }

    public int getNivel_emergencia() {
        return nivel_emergencia;
    }

    public void setNivel_emergencia(int nivel_emergencia) {
        this.nivel_emergencia = nivel_emergencia;
    }


}
