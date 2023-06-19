package com.seguridad.seguridad.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "emergencia_reportada")
public class EmergenciaReportada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int emergenciaReportada_id;
    private String codigo;
    private boolean estadoEmergencia;
    private Date fechaCreacion;
    private Date FechaModificacion;

//    RELACION CON EMERGENCIA
    @OneToOne
    @JoinColumn(name = "emergencia_id")
    private Emergencia emergencia;

//    RELACION CON USUARIO
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuarios usuario;

    public int getEmergenciaReportada_id() {
        return emergenciaReportada_id;
    }

    public void setEmergenciaReportada_id(int emergenciaReportada_id) {
        this.emergenciaReportada_id = emergenciaReportada_id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public boolean isEstadoEmergencia() {
        return estadoEmergencia;
    }

    public void setEstadoEmergencia(boolean estadoEmergencia) {
        this.estadoEmergencia = estadoEmergencia;
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

    public Emergencia getEmergencia() {
        return emergencia;
    }

    public void setEmergencia(Emergencia emergencia) {
        this.emergencia = emergencia;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
    
    

}
