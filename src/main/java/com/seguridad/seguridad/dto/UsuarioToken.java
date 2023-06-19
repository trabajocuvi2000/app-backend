
package com.seguridad.seguridad.dto;

import com.seguridad.seguridad.entities.Usuarios;


public class UsuarioToken {
    
    private Usuarios usuario;
    private String token;
    private boolean isLogin;    


    public UsuarioToken() {
    }

    public UsuarioToken(Usuarios usuario, String token, boolean isLogin) {
        this.usuario = usuario;
        this.token = token;
        this.isLogin = isLogin;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isIsLogin() {
        return isLogin;
    }

    public void setIsLogin(boolean isLogin) {
        this.isLogin = isLogin;
    }

    
    
    
}
