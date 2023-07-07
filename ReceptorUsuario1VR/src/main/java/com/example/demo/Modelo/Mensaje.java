package com.example.demo.Modelo;

import java.time.LocalDateTime;

public class Mensaje {
    private LocalDateTime fechaHora;
    private String mensaje;
    private String usuario;

    public Mensaje() {
        
    }

    public Mensaje(LocalDateTime fechaHora, String mensaje, String usuario) {
        this.fechaHora = fechaHora;
        this.mensaje = mensaje;
        this.usuario = usuario;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
