package com.example.productosbc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.*;

import java.util.Collections;

//@Component
//@Configuration
//@EnableSwagger2
public class  SwaggerConfiguration {

/*
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.productosbc"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.getApiInfo());
    }


    private ApiInfo getApiInfo(){
        return new ApiInfo("Productos",
                "API para gestionar productos",
                "1.0.0",
                "",
                new Contact("Gomez Geneiro Maximiliano Nahuel","https://github.com/Maxigoge/Productosbc/tree/master","kraizyn@gmail.com"),
                "LICENSE",
                "LICENSE URL",
                Collections.emptyList());
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/api/v2/api-docs", "/v2/api-docs");
        registry.addRedirectViewController("/api/swagger-resources/configuration/ui", "/swagger-resources/configuration/ui");
        registry.addRedirectViewController("/api/swagger-resources/configuration/security", "/swagger-resources/configuration/security");
        registry.addRedirectViewController("/api/swagger-resources", "/swagger-resources");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }*/
}