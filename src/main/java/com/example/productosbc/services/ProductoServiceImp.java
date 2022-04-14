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
    public Iterable<Producto> findAll() {
        return prod.findAll();
    }

    @Override
    public String findById(Long id) throws ProductoException {

        //try {
            Optional<Producto> productoOptional = prod.findById(id);
            //return prod.findById(id);
            if (!productoOptional.isPresent()) {
                throw new ProductoException("PRODUCTO_NO_EXISTE");
            } else {
                return productoOptional.toString();
            }
        //} catch ( ProductoException e) {
          //  throw new ProductoException(e.getMessage());
        //}
    }

    @Override
    public Producto save(Producto producto) {
        return prod.save(producto);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        prod.deleteById(id);
    }
}
