
package com.seguridad.seguridad.controller;

import com.seguridad.seguridad.entities.Usuarios;
import com.seguridad.seguridad.model.UsuarioUpdateComunidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class UsuarioSocketController {
    
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    
    @MessageMapping("/usuario")// recive el mensaje -> /app/message "app" es de "WebSocketConfig"
    @SendTo("/chatroom/usuario")// envia el mensaje, before it was "comunidad" instead of "chatroom" and in that way it did not worke
    public UsuarioUpdateComunidad recivirEmergencia(@Payload UsuarioUpdateComunidad usuario) {
//        System.out.println("Emergencia reportada "+emergenciaId);
        return usuario;
    }
    
}
