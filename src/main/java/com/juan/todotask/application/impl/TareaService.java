package com.juan.todotask.application.impl;

import com.juan.todotask.application.ITareaService;
import com.juan.todotask.application.dto.CrearTareaDTO;
import com.juan.todotask.application.dto.TareaDTO;
import com.juan.todotask.application.exception.TareaNotFoudException;
import com.juan.todotask.application.mappers.TareaMapper;
import com.juan.todotask.domain.Tarea;
import com.juan.todotask.domain.TareaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class TareaService implements ITareaService {

    private final TareaRepository tareaRepository;
    private final TareaMapper tareaMapper;

    @Override
    @Transactional
    public TareaDTO crearTarea(CrearTareaDTO crearTareaDTO) {
        Tarea nuevaTarea = new Tarea(crearTareaDTO.getTitulo(), crearTareaDTO.getDescripcion());
        Tarea tareaGuardada = tareaRepository.save(nuevaTarea);
        return tareaMapper.toDto(tareaGuardada);
    }
    @Override
    public TareaDTO obtenerTareaPorId(Long idTarea) {
        Tarea tarea = tareaRepository.findById(idTarea).orElseThrow(() -> new TareaNotFoudException(idTarea));
        return tareaMapper.toDto(tarea);
    }

    @Override
    public List<TareaDTO> obtenerTodasLasTareas() {
        List<Tarea> tareas = tareaRepository.findAll();
        return tareaMapper.toDtoList(tareas);
    }

    @Override
    public TareaDTO marcarTareaComoCompletada(Long id) {
        Tarea tarea = tareaRepository.findById(id).orElseThrow(() -> new TareaNotFoudException(id));
        tarea.setCompletada(true);
        Tarea tareaActualizada = tareaRepository.save(tarea);
        return tareaMapper.toDto(tareaActualizada);
    }

    @Override
    public void eliminarTarea(Long id) {
        if (!tareaRepository.existsById(id)) {
            throw new TareaNotFoudException(id);
        }
        tareaRepository.deleteById(id);
    }
}
