package com.examen.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Manejar profesor no encontrado
    @ExceptionHandler(ProfesorNotFoundException.class)
    public ResponseEntity<Map<String, String>> manejarNoEncontrado(
            ProfesorNotFoundException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("mensaje", ex.getMessage()));
    }

    // Manejar proveedor no encontrado
    @ExceptionHandler(ProveedorNotFoundException.class)
    public ResponseEntity<Map<String, String>> manejarProveedorNoEncontrado(
            ProveedorNotFoundException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("mensaje", ex.getMessage()));
    }

    @ExceptionHandler(EmpleadoNotFoundException.class)
public ResponseEntity<Map<String, String>> manejarEmpleadoNoEncontrado(
        EmpleadoNotFoundException ex) {

    return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(Map.of("mensaje", ex.getMessage()));
}                           
}