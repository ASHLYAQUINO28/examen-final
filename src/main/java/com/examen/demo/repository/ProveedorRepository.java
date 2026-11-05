package com.examen.demo.repository;

import com.examen.demo.model.Proveedor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProveedorRepository {

    private List<Proveedor> proveedores = new ArrayList<>();
    private Long contadorId = 1L;

    // Guardar proveedor
    public Proveedor guardar(Proveedor proveedor) {
        proveedor.setId(contadorId++);
        proveedores.add(proveedor);
        return proveedor;
    }

    // Obtener todos los proveedores
    public List<Proveedor> obtenerTodos() {
        return proveedores;
    }

    // Buscar proveedor por ID
    public Optional<Proveedor> buscarPorId(Long id) {
        return proveedores.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    // Filtrar por categoría
    public List<Proveedor> buscarPorCategoria(String categoria) {
        return proveedores.stream()
                .filter(p -> p.getCategoria().equalsIgnoreCase(categoria))
                .toList();
    }
}