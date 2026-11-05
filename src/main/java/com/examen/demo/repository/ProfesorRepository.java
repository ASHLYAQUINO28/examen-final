package com.examen.demo.repository;

import com.examen.demo.model.Profesor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProfesorRepository {

    private List<Profesor> profesores = new ArrayList<>();
    private Long contadorId = 1L;

    // Guardar profesor
    public Profesor guardar(Profesor profesor) {
        profesor.setId(contadorId++);
        profesores.add(profesor);
        return profesor;
    }

    // Obtener todos los profesores
    public List<Profesor> obtenerTodos() {
        return profesores;
    }

    // Buscar profesor por ID
    public Optional<Profesor> buscarPorId(Long id) {
        return profesores.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    // Filtrar por especialidad
    public List<Profesor> buscarPorEspecialidad(String especialidad) {
        return profesores.stream()
                .filter(p -> p.getEspecialidad().equalsIgnoreCase(especialidad))
                .toList();
    }
}