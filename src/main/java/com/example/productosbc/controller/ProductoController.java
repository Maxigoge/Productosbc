package com.example.productosbc.controller;

import com.example.productosbc.entity.Producto;
import com.example.productosbc.exceptions.ProductoException;
import com.example.productosbc.exceptions.ValidationException;
import com.example.productosbc.models.ProductoModels;
import com.example.productosbc.response.SuccessfulResponse;
import com.example.productosbc.services.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    public ResponseEntity<?> create (@Valid @RequestBody ProductoModels productoModel) {
        Producto producto = modelMapper.map(productoModel, Producto.class);
        producto.setFechaCreacion(LocalDateTime.now().toString());

        return ResponseEntity.status(HttpStatus.CREATED).body(prodServ.save(producto));
    }

    @GetMapping("/todos")
    public Iterable<Producto> getAll() {
        return prodServ.findAll();
    }


    @GetMapping("/{id}")
    @Operation(summary = "Obtener formulario por id",
            description = "Retorna un formulario por su id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204 - RESPUESTA_EXITOSA"),
            @ApiResponse(responseCode = "404 - PRODUCTO_NO_EXISTE", description = "El producto(id="+"/{id}"+") no existe"),
            @ApiResponse(responseCode = "500", description = "Se produjo un error desconocido")
    })
    public String reader(@PathVariable(value = "id") Long id_producto) throws ProductoException, ValidationException {
    //public ResponseEntity<?> reader(@PathVariable(value = "id") Long id_producto) throws ProductoException, ValidationException {
        //return SuccessfulResponse(prodServ.findById(id_producto));
        return prodServ.findById(id_producto);
    }


/*
    @RequestMapping(value = "/{id}",method=RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id_producto) throws ProductoException, ValidationException {

        //Optional<Producto> productoOptional = prodServ.findById(id_producto);
        if (!prodServ.findById(id_producto).isPresent()) {
            return ResponseEntity.notFound().build();
        } else {
            prodServ.deleteById(id_producto);
            return ResponseEntity.ok().build();
        }
    }*/


}
