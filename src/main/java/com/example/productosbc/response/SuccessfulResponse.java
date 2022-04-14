package com.example.productosbc.response;

import com.example.productosbc.entity.Producto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Optional;

@Data
@EqualsAndHashCode(callSuper = false)
public class SuccessfulResponse extends GenericResponse {

    private Optional<Producto> data;

    public SuccessfulResponse(Optional<Producto> data) {
        this.data = data;
    }

    public Optional<Producto> getData() {
        return data;
    }

    public void setData(Optional<Producto> data) {
        this.data = data;
    }
}