package com.examen.demo.controller;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examen.demo.model.Empleado;
import com.examen.demo.service.EmpleadoService;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    private final EmpleadoService service;

    public EmpleadoController(EmpleadoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Empleado> crear(
            @Valid @RequestBody Empleado empleado) {

        Empleado nuevo = service.crear(empleado);

        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @GetMapping
    public ResponseEntity<List<Empleado>> obtenerTodos(
            @RequestParam(required = false) String especialidad) {

        if (especialidad != null && !especialidad.isBlank()) {
            return ResponseEntity.ok(
                    service.filtrarPorEspecialidad(especialidad));
        }

        return ResponseEntity.ok(service.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> obtenerPorId(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.obtenerPorId(id));
    }
}