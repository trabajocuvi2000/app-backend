
package com.seguridad.seguridad.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dispositivo")
public class Dispositivo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dispositivo_id;
    private String codigo;
    private String nombre;
    private boolean isActiva;
    @Column(length = 5000)
    private String descripcion;
    
////    RELACION COMUNIDAD
//    @ManyToOne
//    @JoinColumn(name = "comunidad_id")
//    private Comunidad comunidad;
//    
//    RELACION TIPO DISPOSITIVO
    @ManyToOne
    @JoinColumn(name = "tipoDispositivo_id")
    private TipoDispositivo tipoDispositivo;

    public int getDispositivo_id() {
        return dispositivo_id;
    }

    public void setDispositivo_id(int dispositivo_id) {
        this.dispositivo_id = dispositivo_id;
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

    public boolean isIsActiva() {
        return isActiva;
    }
    
    public void setIsActiva(boolean isActiva) {
        this.isActiva = isActiva;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoDispositivo getTipoDispositivo() {
        return tipoDispositivo;
    }

    public void setTipoDispositivo(TipoDispositivo tipoDispositivo) {
        this.tipoDispositivo = tipoDispositivo;
    }

    
}
