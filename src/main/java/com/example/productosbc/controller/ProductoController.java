package com.example.productosbc.controller;

import com.example.productosbc.exceptions.ProductoException;
import com.example.productosbc.exceptions.ValidationException;
import com.example.productosbc.models.CrearProducto;
import com.example.productosbc.models.ErrorGenerico;
import com.example.productosbc.models.ErrorNoEncontrado;
import com.example.productosbc.models.Producto;
import com.example.productosbc.services.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;


@RestController
@RequestMapping (value = "/productos")
@CrossOrigin ("*")
public class ProductoController {
    @Autowired
    private ProductoService prodServ;
    private ModelMapper modelMapper = new ModelMapper();

    @Operation(summary = "Crear un producto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Respuesta exitosa",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = com.example.productosbc.entity.Producto.class)) }),

            @ApiResponse(responseCode = "500", description = "Error del servidor",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorGenerico.class)) }) })
    @PostMapping ("")
    public ResponseEntity<?> create (@Valid @RequestBody CrearProducto productoModel) throws Exception {
        com.example.productosbc.entity.Producto producto = modelMapper.map(productoModel, com.example.productosbc.entity.Producto.class);
        producto.setFechaCreacion(LocalDateTime.now().toString());

        return ResponseEntity.status(HttpStatus.CREATED).body(prodServ.save(producto));
    }

    @Operation(summary = "Retorna la lista de productos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta exitosa",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = com.example.productosbc.entity.Producto.class)) }),

            @ApiResponse(responseCode = "500", description = "Error del servidor",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorGenerico.class)) }) })
    @GetMapping("")
    public Iterable<com.example.productosbc.entity.Producto> getAll() throws Exception {
        return prodServ.findAll();
    }

    @Operation(summary = "Retorna un proucto por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta exitosa",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = com.example.productosbc.entity.Producto.class)) }),

            @ApiResponse(responseCode = "404", description = "El producto no existe",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorNoEncontrado.class)) }),

            @ApiResponse(responseCode = "500", description = "Error del servidor",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorGenerico.class)) }) })
    @GetMapping("/{idProducto}")
    public ResponseEntity<?> reader(@PathVariable(value = "idProducto") Long id_producto) throws ProductoException, ValidationException {
    if (prodServ.findById(id_producto) == null) {
        throw new ProductoException("PRODUCTO_NO_EXISTE");
    }
        //return prodServ.findById(id_producto).orElseThrow(() -> new ProductoNotFoundException());
        return ResponseEntity.ok(prodServ.findById(id_producto));
    }

    @Operation(summary = "Eliminar un proucto por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta exitosa",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = com.example.productosbc.entity.Producto.class)) }),

            @ApiResponse(responseCode = "404", description = "El producto no existe",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorNoEncontrado.class)) }),

            @ApiResponse(responseCode = "500", description = "Error del servidor",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorGenerico.class)) }) })
    @RequestMapping(value = "/{idProducto}",method=RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable(value = "idProducto") Long id_producto) throws Exception {

        if (prodServ.findById(id_producto) == null) {
            //return ResponseEntity.notFound().build();
            throw new ProductoException("PRODUCTO_NO_EXISTE");
        } else {
            prodServ.deleteById(id_producto);
            return ResponseEntity.ok().build();
        }
    }


}
