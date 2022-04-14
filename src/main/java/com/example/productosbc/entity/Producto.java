package com.example.productosbc.entity;

import javax.persistence.*;

@Entity
@Table(name = "Productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_prodcuto;

    @Column(length = 100)
    private String nombre;

    @Column(length = 5000)
    private String descripcion;

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

    public Producto() {
    }

    public Producto(Long id_prodcuto, String nombre, String descripcion) {
        this.id_prodcuto = id_prodcuto;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }


}
