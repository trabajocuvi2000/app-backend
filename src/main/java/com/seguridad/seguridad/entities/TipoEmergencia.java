/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.seguridad.seguridad.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_emergencia")
public class TipoEmergencia {
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tipoEmergencia_id;
    private String tipoEmergencia;
    private int tipoEmergenciaValor;

    public int getTipoEmergencia_id() {
        return tipoEmergencia_id;
    }

    public void setTipoEmergencia_id(int tipoEmergencia_id) {
        this.tipoEmergencia_id = tipoEmergencia_id;
    }

    public String getTipoEmergencia() {
        return tipoEmergencia;
    }

    public void setTipoEmergencia(String tipoEmergencia) {
        this.tipoEmergencia = tipoEmergencia;
    }

    public int getTipoEmergenciaValor() {
        return tipoEmergenciaValor;
    }

    public void setTipoEmergenciaValor(int tipoEmergenciaValor) {
        this.tipoEmergenciaValor = tipoEmergenciaValor;
    }

    
    
    
}
