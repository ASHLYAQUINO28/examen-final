package com.examen.demo.service;

import com.examen.demo.model.Proveedor;
import com.examen.demo.repository.ProveedorRepository;
import com.examen.demo.exception.ProveedorNotFoundException;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorService {

    private final ProveedorRepository repository;

    public ProveedorService(ProveedorRepository repository) {
        this.repository = repository;
    }

    // Crear proveedor
    public Proveedor crear(Proveedor proveedor) {
        return repository.guardar(proveedor);
    }

    // Obtener todos los proveedores
    public List<Proveedor> obtenerTodos() {
        return repository.obtenerTodos();
    }

    // Filtrar por categoría
    public List<Proveedor> filtrarPorCategoria(String categoria) {
        return repository.buscarPorCategoria(categoria);
    }

    // Obtener proveedor por ID
    public Proveedor obtenerPorId(Long id) {
        return repository.buscarPorId(id)
                .orElseThrow(() -> new ProveedorNotFoundException(
                        "Proveedor no encontrado con ID: " + id));
    }
}