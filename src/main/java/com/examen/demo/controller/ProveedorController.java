package com.examen.demo.controller;

import com.examen.demo.model.Proveedor;
import com.examen.demo.service.ProveedorService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {

    private final ProveedorService service;

    public ProveedorController(ProveedorService service) {
        this.service = service;
    }

    // Crear proveedor
    @PostMapping
    public ResponseEntity<Proveedor> crear(
            @Valid @RequestBody Proveedor proveedor) {

        Proveedor nuevo = service.crear(proveedor);

        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    // Obtener todos o filtrar por categoría
    @GetMapping
    public ResponseEntity<List<Proveedor>> obtenerTodos(
            @RequestParam(required = false) String categoria) {

        if (categoria != null && !categoria.isBlank()) {
            return ResponseEntity.ok(
                    service.filtrarPorCategoria(categoria));
        }

        return ResponseEntity.ok(service.obtenerTodos());
    }

    // Obtener proveedor por ID
    @GetMapping("/{id}")
    public ResponseEntity<Proveedor> obtenerPorId(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.obtenerPorId(id));
    }
}