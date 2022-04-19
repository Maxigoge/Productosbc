package com.example.productosbc.controller;

import com.example.productosbc.entity.Producto;
import com.example.productosbc.exceptions.ProductoException;
import com.example.productosbc.exceptions.ValidationException;
import com.example.productosbc.models.ProductoModels;
import com.example.productosbc.services.ProductoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Optional;


@RestController
@RequestMapping ("/api/productos")
@CrossOrigin ("*")
public class ProductoController {
    @Autowired
    private ProductoService prodServ;
    private ModelMapper modelMapper = new ModelMapper();

    @PostMapping ("/nuevo")
    public ResponseEntity<?> create (@Valid @RequestBody ProductoModels productoModel) throws Exception {
        Producto producto = modelMapper.map(productoModel, Producto.class);
        producto.setFechaCreacion(LocalDateTime.now().toString());

        return ResponseEntity.status(HttpStatus.CREATED).body(prodServ.save(producto));
    }

    @GetMapping("/todos")
    public Iterable<Producto> getAll() throws Exception {
        return prodServ.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> reader(@PathVariable(value = "id") Long id_producto) throws ProductoException, ValidationException {
    if (prodServ.findById(id_producto) == null) {
        throw new ProductoException("PRODUCTO_NO_EXISTE");
    }
        return ResponseEntity.ok(prodServ.findById(id_producto));
    }

    @RequestMapping(value = "/{id}",method=RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id_producto) throws Exception {

        if (prodServ.findById(id_producto) == null) {
            //return ResponseEntity.notFound().build();
            throw new ProductoException("PRODUCTO_NO_EXISTE");
        } else {
            prodServ.deleteById(id_producto);
            return ResponseEntity.ok().build();
        }
    }


}
