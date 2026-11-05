package com.examen.demo.service;

import com.examen.demo.model.Empleado;
import com.examen.demo.repository.EmpleadoRepository;
import com.examen.demo.exception.EmpleadoNotFoundException;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

    private final EmpleadoRepository repository;

    public EmpleadoService(EmpleadoRepository repository) {
        this.repository = repository;
    }

    public Empleado crear(Empleado empleado) {
        return repository.guardar(empleado);
    }

    public List<Empleado> obtenerTodos() {
        return repository.obtenerTodos();
    }

    public List<Empleado> filtrarPorEspecialidad(String especialidad) {
        return repository.buscarPorEspecialidad(especialidad);
    }

    public Empleado obtenerPorId(Long id) {
        return repository.buscarPorId(id)
                .orElseThrow(() -> new EmpleadoNotFoundException(
                        "Empleado no encontrado con ID: " + id));
    }
}