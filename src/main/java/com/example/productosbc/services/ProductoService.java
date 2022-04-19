package com.example.productosbc.services;

import com.example.productosbc.entity.Producto;
import com.example.productosbc.exceptions.ProductoException;
import com.example.productosbc.exceptions.ValidationException;

import java.util.Optional;

public interface ProductoService {
    public Iterable<Producto> findAll() throws Exception;

    public Optional<Producto> findById(Long id) throws ValidationException, ProductoException;

    public Producto save(Producto producto) throws Exception;

    public void deleteById(Long id) throws Exception;
}
