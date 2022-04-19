package com.example.productosbc.exceptions;

import java.util.Date;

public class ExceptionResponse {
    private String mensaje;
    private String codigo;

    public ExceptionResponse(String codigo, String mensaje) {
        this.mensaje = mensaje;
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}