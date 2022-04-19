package com.example.productosbc.exceptions;

import java.util.Date;
import java.util.Iterator;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {

        String[] getId = request.getDescription(false).split("/");

        if ((getId[2]).chars().allMatch(Character::isDigit)) {
            ExceptionResponse exceptionResponse = new ExceptionResponse(
                    "El producto(id=" + getId[2]  + ") no existe",
                    ex.getMessage());

            return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            ExceptionResponse exceptionResponse = new ExceptionResponse( "ERROR_DESCONOCIDO",
                    "Se produjo un error desconocido");
            return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }



    }

    @ExceptionHandler(ProductoNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleUserNotFoundException(ProductoNotFoundException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                request.getDescription(false), ex.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

}