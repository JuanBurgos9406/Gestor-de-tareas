package com.juan.todotask.infraestructure.web;

import com.juan.todotask.application.dto.CrearTareaDTO;
import com.juan.todotask.application.dto.TareaDTO;
import com.juan.todotask.application.impl.TareaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tareas")
public class TareaController {

    private final TareaService tareaService;

    @GetMapping("/{idTarea}")
    public ResponseEntity<TareaDTO>obtenerTareaPorId(TareaDTO tareaDTO, Long idTarea){
        TareaDTO tarea = tareaService.obtenerTareaPorId(tareaDTO.getIdTarea());
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<TareaDTO>> obtenerTodasLasTareas(){
        List<TareaDTO> tareas = tareaService.obtenerTodasLasTareas();
        return ResponseEntity.ok(tareas);
    }

    @PostMapping
    public ResponseEntity<TareaDTO> crearTarea(@Valid @RequestBody CrearTareaDTO tareaDTO){
        TareaDTO nuevaTarea = tareaService.crearTarea(tareaDTO);
        return ResponseEntity.ok(nuevaTarea);
    }

    @PutMapping("/{id}/completar")
    public ResponseEntity<TareaDTO> marcarTareaComoCompletada(@PathVariable Long id) {
        TareaDTO tareaCompletada = tareaService.marcarTareaComoCompletada(id);
        return ResponseEntity.ok(tareaCompletada);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTarea(@PathVariable Long id) {
        tareaService.eliminarTarea(id);
        return ResponseEntity.noContent().build();

}
