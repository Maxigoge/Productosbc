package com.example.productosbc.controller;

import com.example.productosbc.entity.Producto;
import com.example.productosbc.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping ("/api/productos")
@CrossOrigin ("*")
public class ProductoController {
    @Autowired
    private ProductoService prodServ;

    @PostMapping ("/nuevo")
    public ResponseEntity<?> create (@Valid @RequestBody Producto producto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(prodServ.save(producto));
    }

    @GetMapping("/todos")
    public Iterable<Producto> getAll() {
        return prodServ.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> reader(@PathVariable(value = "id") Long id_prodcuto) {
        Optional<Producto> productoOptional = prodServ.findById(id_prodcuto);
        if (!productoOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(productoOptional);
        }
    }

    @RequestMapping(value = "/{id}",method=RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id_prodcuto) {

        //Optional<Producto> productoOptional = prodServ.findById(id_prodcuto);
        if (!prodServ.findById(id_prodcuto).isPresent()) {
            return ResponseEntity.notFound().build();
        } else {
            prodServ.deleteById(id_prodcuto);
            return ResponseEntity.ok().build();
        }
    }


}
