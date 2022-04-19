package com.example.productosbc;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Productos", version = "1.0.0", description = "API para gestionar productos"))
public class ProductosbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductosbcApplication.class, args);

	}

}
