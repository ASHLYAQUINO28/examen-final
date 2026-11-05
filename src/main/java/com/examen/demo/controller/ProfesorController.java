package com.examen.demo.controller;

import com.examen.demo.model.Profesor;
import com.examen.demo.service.ProfesorService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {

    private final ProfesorService service;

    // Inyección de dependencias
    public ProfesorController(ProfesorService service) {
        this.service = service;
    }

    // Crear profesor
    @PostMapping
    public ResponseEntity<Profesor> crear(
            @Valid @RequestBody Profesor profesor) {

        Profesor nuevo = service.crear(profesor);

        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    // Consultar todos los profesores o filtrar por especialidad
    @GetMapping
    public ResponseEntity<List<Profesor>> obtenerTodos(
            @RequestParam(required = false) String especialidad) {

        if (especialidad != null && !especialidad.isBlank()) {
            return ResponseEntity.ok(
                    service.filtrarPorEspecialidad(especialidad));
        }

        return ResponseEntity.ok(service.obtenerTodos());
    }

    // Consultar profesor por ID
    @GetMapping("/{id}")
    public ResponseEntity<Profesor> obtenerPorId(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.obtenerPorId(id));
    }
}