
package com.seguridad.seguridad.controller;

import com.seguridad.seguridad.model.DispositivoUsuaioActualizado;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class DispositivoUsuarioSocketController {
    
    @MessageMapping("/dispositivousuario")// recive el mensaje -> /app/message "app" es de "WebSocketConfig"
    @SendTo("/dispositivo/usuario")// envia el mensaje 
    public DispositivoUsuaioActualizado receiveMessage(@Payload DispositivoUsuaioActualizado dispositivoActualizado) {
        return dispositivoActualizado;
    }
}
