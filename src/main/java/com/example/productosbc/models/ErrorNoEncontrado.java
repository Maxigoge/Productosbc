package com.example.productosbc.models;

import io.swagger.v3.oas.annotations.media.Schema;

public class ErrorNoEncontrado {
    @Schema(description = "Código de error.")
    private final String codigo = "PRODCUTO_NO_EXISTE";
    @Schema(description = "Mensaje de error")
    private final String mensaje = "El producto(id=12) no existe";

    public ErrorNoEncontrado() {
    }

    public String getCodigo() {
        return codigo;
    }


    public String getMensaje() {
        return mensaje;
    }
}


