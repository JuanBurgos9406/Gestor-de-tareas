package com.juan.todotask.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CrearTareaDTO {
    @NotBlank(message = "el campo titulo no puede estar vacio")
    @Size(min = 10, message = "el campo titulo no puede tener menos de 10 caracteres")
    private String titulo;

    @NotBlank(message = "el campo descrpcion no puede estar vacio")
    private String descripcion;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion (String descripcion) {
        this.descripcion = descripcion;
    }






}
