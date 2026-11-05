package com.examen.demo.service;

import com.examen.demo.model.Profesor;
import com.examen.demo.repository.ProfesorRepository;
import com.examen.demo.exception.ProfesorNotFoundException;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorService {

    private final ProfesorRepository repository;

    public ProfesorService(ProfesorRepository repository) {
        this.repository = repository;
    }

    // Crear profesor
    public Profesor crear(Profesor profesor) {
        return repository.guardar(profesor);
    }

    // Obtener todos los profesores
    public List<Profesor> obtenerTodos() {
        return repository.obtenerTodos();
    }

    // Filtrar por especialidad
    public List<Profesor> filtrarPorEspecialidad(String especialidad) {
        return repository.buscarPorEspecialidad(especialidad);
    }

    // Obtener profesor por ID
    public Profesor obtenerPorId(Long id) {
        return repository.buscarPorId(id)
                .orElseThrow(() -> new ProfesorNotFoundException(
                        "Profesor no encontrado con ID: " + id));
    }
}