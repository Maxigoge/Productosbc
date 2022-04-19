package com.example.productosbc.entity;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "Productos")
public class Producto {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Id del producto")
    private Long id_prodcuto;

    @Column(length = 100)
    @NotNull
    @Size(max = 100)
    @Schema(description = "Nombre del producto")
    private String nombre;

    @Column(length = 5000)
    @Size(max = 5000)
    @Schema(description = "Descripción del producto")
    private String descripcion;

    @Column
    @NotNull
    @Schema(description = "Precio del producto")
    private Long precio;

    @Column
    @NotNull
    private String fechaCreacion;

    public Producto() {
    }

    public Producto(Long id_prodcuto, String nombre, String descripcion, Long precio, String fechaCreacion) {
        this.id_prodcuto = id_prodcuto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaCreacion = fechaCreacion;
    }

    public Long getId_prodcuto() {
        return id_prodcuto;
    }

    public void setId_prodcuto(Long id_prodcuto) {
        this.id_prodcuto = id_prodcuto;
    }

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

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
