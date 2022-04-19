package com.example.productosbc.models;

import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.boot.context.properties.bind.DefaultValue;

public class ErrorGenerico {
    @Schema(description = "Código de error.")
    private String codigo = "ERROR_DESCONOCIDO";
    @Schema(description = "Mensaje de error")
    private String mensaje = "Se produjo un error desconocido";

    public ErrorGenerico(String codigo, String mensaje) {
        this.codigo = codigo;
        this.mensaje = mensaje;
    }

    public ErrorGenerico() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
