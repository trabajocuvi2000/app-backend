/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.seguridad.seguridad.entities;

import com.seguridad.seguridad.model.Status;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mensajes_comunidad")
public class MensajeComunidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mensajes_comunidad_id;
    private String senderName;
    private int senderId;
    private String receiverName;
    private int receiveGroup;
    private String message;
    private Date date;
    private Status status;

    
    @ManyToOne
    @JoinColumn(name = "comunidad_id")
    private Comunidad comunidad;
    
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuarios usuarios;

    public int getMensajes_comunidad_id() {
        return mensajes_comunidad_id;
    }

    public void setMensajes_comunidad_id(int mensajes_comunidad_id) {
        this.mensajes_comunidad_id = mensajes_comunidad_id;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public int getReceiveGroup() {
        return receiveGroup;
    }

    public void setReceiveGroup(int receiveGroup) {
        this.receiveGroup = receiveGroup;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Comunidad getComunidad() {
        return comunidad;
    }

    public void setComunidad(Comunidad comunidad) {
        this.comunidad = comunidad;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    
    
}
