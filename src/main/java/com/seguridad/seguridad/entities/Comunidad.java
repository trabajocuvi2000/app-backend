package com.seguridad.seguridad.entities;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "comunidad")
public class Comunidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int comunidad_id;
    private String codigo;
    private String nombre;
    @Column(length = 5000)
    private String descripcion;
    @Column(length = 3000)
    private String direccion;
    private Date fechaCreacion;
    private Date FechaModificacion;

//    RELACION CON EMERGENCIA
//    @ManyToMany
//    @JoinColumn(name = "emergencia_id")
//    private List<Emergencia> emergencias;
    @OneToMany
    @JoinColumn(name = "dispositivo_id")
    private List<Dispositivo> dispositivos;

    @ManyToMany
    @JoinTable(name = "comunidad_emergencias",
             joinColumns = @JoinColumn(name = "comunidad_id"),
             inverseJoinColumns = @JoinColumn(name = "emergencia_id")
    )
    private List<Emergencia> emergencias;

    public int getComunidad_id() {
        return comunidad_id;
    }

    public void setComunidad_id(int comunidad_id) {
        this.comunidad_id = comunidad_id;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public List<Emergencia> getEmergencias() {
        return emergencias;
    }

    public void setEmergencias(List<Emergencia> emergencias) {
        this.emergencias = emergencias;
    }

    public List<Dispositivo> getDispositivos() {
        return dispositivos;
    }

    public void setDispositivos(List<Dispositivo> dispositivos) {
        this.dispositivos = dispositivos;
    }
    
    

}
