/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.seguridad.seguridad.model;

import com.seguridad.seguridad.entities.EmergenciaReportada;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EmergenciaID {
    
    private int emergenciaReportadaId;
    private int comunidadId;
    private int usuarioSenderId;
    private int emergenciaId;
    private EmergenciaReportada emergenciaReportada;
    
}
