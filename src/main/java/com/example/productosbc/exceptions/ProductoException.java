package com.example.productosbc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "ERROR_DESCONOCIDO")
public class ProductoException extends Exception {
    public ProductoException(String message) {
    super(message);
    }
}