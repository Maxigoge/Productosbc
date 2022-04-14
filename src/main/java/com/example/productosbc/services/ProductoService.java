package com.example.productosbc.services;

import com.example.productosbc.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    public Iterable<Producto> findAll();

    public Optional<Producto> findById(Long id) ;

    public Producto save(Producto producto);

    public void deleteById(Long id) ;
}
