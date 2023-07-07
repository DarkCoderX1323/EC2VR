package com.example.demo.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Modelo.Mensaje;

import jakarta.jms.*;

@RestController
public class ControladorMensaje {

    @Autowired
    JmsTemplate jmsTemplate;

    @PostMapping("/mensaje")
    public ResponseEntity<Mensaje> enviarMensaje(@RequestBody Mensaje mensaje) {
        try {
            Queue cola = jmsTemplate.getConnectionFactory()
                    .createConnection()
                    .createSession()
                    .createQueue("Usuario2");
            Mensaje mensajeActualizado = new Mensaje(mensaje.getFechaHora(), mensaje.getMensaje(), "Usuario2");
            jmsTemplate.convertAndSend(cola, mensajeActualizado);
            return new ResponseEntity<>(mensajeActualizado, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

