package com.juan.todotask.application.exception;

public class TareaNotFoudException extends RuntimeException {

    public TareaNotFoudException(Long id) {
        super("Tarea con id " + id + " no encontrada");

    }
}
