/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.seguridad.seguridad.repository;

import com.seguridad.seguridad.entities.Emergencia;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmergenciaRepo extends JpaRepository<Emergencia, Integer>{
    
}
