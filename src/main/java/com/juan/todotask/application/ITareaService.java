package com.juan.todotask.application;

import com.juan.todotask.application.dto.CrearTareaDTO;
import com.juan.todotask.application.dto.TareaDTO;

import java.util.List;

public interface ITareaService {

    TareaDTO crearTarea(CrearTareaDTO tareaDTO);
    TareaDTO obtenerTareaPorId(Long id);
    List<TareaDTO> obtenerTodasLasTareas();
    TareaDTO marcarTareaComoCompletada(Long id);
    void eliminarTarea(Long id);
}
