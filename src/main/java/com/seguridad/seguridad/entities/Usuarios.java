package com.seguridad.seguridad.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int usuario_id;
    private String correo_1;
    private String correo_2;
    @Column(length = 1000)
    private String contrasena;
    private boolean isAdmin;
    @Column(length = 10000)
    private String tokenFirebase;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuarioVecino_id")
    private UsuarioVecino usuarioVecino;

    @ManyToOne
    @JoinColumn(name = "comunidad_id")
    private Comunidad comunidad;

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getCorreo_1() {
        return correo_1;
    }

    public void setCorreo_1(String correo_1) {
        this.correo_1 = correo_1;
    }

    public String getCorreo_2() {
        return correo_2;
    }

    public void setCorreo_2(String correo_2) {
        this.correo_2 = correo_2;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public UsuarioVecino getUsuarioVecino() {
        return usuarioVecino;
    }

    public void setUsuarioVecino(UsuarioVecino usuarioVecino) {
        this.usuarioVecino = usuarioVecino;
    }

 
    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Comunidad getComunidad() {
        return comunidad;
    }

    public void setComunidad(Comunidad comunidad) {
        this.comunidad = comunidad;
    }

    public String getTokenFirebase() {
        return tokenFirebase;
    }
    
    

}
