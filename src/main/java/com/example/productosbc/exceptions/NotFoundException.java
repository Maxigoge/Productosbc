package com.example.productosbc.exceptions;

public class NotFoundException extends GenericServiceException {
    public NotFoundException(String message) {
        super(message);
    }
}
