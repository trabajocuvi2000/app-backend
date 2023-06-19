package com.seguridad.seguridad.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_dispositivo")
public class TipoDispositivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tipoDispositivo_id;
    private String tipoDispositivo;
    private int tipoDispositivoValor;
    @Column(length = 5000)
    private String descripcion;
    private String codigo;
    private Date fechaCreacion;
    private Date fechaModificacion;

    public int getTipoDispositivo_id() {
        return tipoDispositivo_id;
    }

    public void setTipoDispositivo_id(int tipoDispositivo_id) {
        this.tipoDispositivo_id = tipoDispositivo_id;
    }

    public String getTipoDispositivo() {
        return tipoDispositivo;
    }

    public void setTipoDispositivo(String tipoDispositivo) {
        this.tipoDispositivo = tipoDispositivo;
    }

    public int getTipoDispositivoValor() {
        return tipoDispositivoValor;
    }

    public void setTipoDispositivoValor(int tipoDispositivoValor) {
        this.tipoDispositivoValor = tipoDispositivoValor;
    }

    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
    
    

}
