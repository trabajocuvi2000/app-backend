
package com.seguridad.seguridad.model;


public class UsuarioComunidadActualizar {
    
    private int comunidadId;
    private int usuarioVecinoId;
    private int usuarioAdminId;
    private boolean isInCommunity;

    public int getComunidadId() {
        return comunidadId;
    }

    public void setComunidadId(int comunidadId) {
        this.comunidadId = comunidadId;
    }

    public int getUsuarioVecinoId() {
        return usuarioVecinoId;
    }

    public void setUsuarioVecinoId(int usuarioVecinoId) {
        this.usuarioVecinoId = usuarioVecinoId;
    }

    public boolean isIsInCommunity() {
        return isInCommunity;
    }

    public void setIsInCommunity(boolean isInCommunity) {
        this.isInCommunity = isInCommunity;
    }

    public int getUsuarioAdminId() {
        return usuarioAdminId;
    }

    public void setUsuarioAdminId(int usuarioAdminId) {
        this.usuarioAdminId = usuarioAdminId;
    }

}
