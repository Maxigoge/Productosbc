package com.example.productosbc.services;

import com.example.productosbc.entity.Producto;
import com.example.productosbc.exceptions.ProductoException;
import com.example.productosbc.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ProductoServiceImp implements ProductoService{

    @Autowired
    private ProductoRepository prod;

    @Override
    public Iterable<Producto> findAll() throws Exception{
        try {
            return prod.findAll();
        } catch ( Exception e) {
            throw new Exception(("ERROR_DESCONOCIDO"));
        }
    }

    @Override
    public Optional<Producto> findById(Long id) throws ProductoException {

            if (!prod.findById(id).isPresent()) {
                //throw new ProductoException("PRODUCTO_NO_EXISTE");
                Optional<Producto> deva = null;
                return deva;
            } else {
                return prod.findById(id);
            }

    }

    @Override
    public Producto save(Producto producto) throws Exception {
        try {
            return prod.save(producto);
        } catch ( Exception e) {
            throw new Exception("ERROR_DESCONOCIDO");
        }
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        prod.deleteById(id);
    }
}
