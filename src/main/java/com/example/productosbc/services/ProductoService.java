package com.example.productosbc.services;

import com.example.productosbc.entity.Producto;
import com.example.productosbc.exceptions.ProductoException;
import com.example.productosbc.exceptions.ValidationException;

public interface ProductoService {
    public Iterable<Producto> findAll();

    public String findById(Long id) throws ValidationException, ProductoException;

    public Producto save(Producto producto);

    public void deleteById(Long id) ;
}
