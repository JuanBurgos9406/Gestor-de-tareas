package com.juan.todotask.application.mappers;

import com.juan.todotask.application.dto.CrearTareaDTO;
import com.juan.todotask.application.dto.TareaDTO;
import com.juan.todotask.domain.Tarea;

import java.util.List;
import java.util.stream.Collectors;

public class TareaMapper {

    /**
     * Convierte un DTO de creación a una Entidad de Dominio Tarea.
     */
    public Tarea toEntity(CrearTareaDTO dto) {
        // La Entidad Tarea es la que establece valores por defecto como 'fechaCreacion' y 'completada=false'
        return new Tarea(dto.getTitulo(), dto.getDescripcion());
    }

    /**
     * Convierte una Entidad de Dominio Tarea a un DTO de respuesta.
     */
    public TareaDTO toDto(Tarea tarea) {
        if (tarea == null) {
            return null;
        }

        TareaDTO dto = new TareaDTO();
        dto.setIdTarea(tarea.getIdTarea());
        dto.setTitulo(tarea.getTitulo());
        dto.setDescripcion(tarea.getDescripcion());
        dto.setCompletada(tarea.getCompletada());
        dto.setFechaCreacion(tarea.getFechaCreacion());
        return dto;
    }

    /**
     * Convierte una lista de Entidades a una lista de DTOs.
     */
    public List<TareaDTO> toDtoList(List<Tarea> tareas) {
        return tareas.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
