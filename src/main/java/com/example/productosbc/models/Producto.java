package com.example.productosbc.models;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Producto {
    @Schema(description = "Mombre del producto")
    private String nombre;

    @Schema(description = "Descripcion del producto")
    private String descripcion;

    @Schema(description = "Precio del producto")
    private Long precio;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public Producto() {
    }

    public Producto(String nombre, String descripcion, Long precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }
}

