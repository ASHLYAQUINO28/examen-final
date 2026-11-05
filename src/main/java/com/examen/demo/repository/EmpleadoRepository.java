package com.examen.demo.repository;

import com.examen.demo.model.Empleado;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EmpleadoRepository {

    private List<Empleado> empleados = new ArrayList<>();
    private Long contadorId = 1L;

    public Empleado guardar(Empleado empleado) {
        empleado.setId(contadorId++);
        empleados.add(empleado);
        return empleado;
    }

    public List<Empleado> obtenerTodos() {
        return empleados;
    }

    public Optional<Empleado> buscarPorId(Long id) {
        return empleados.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();
    }

    public List<Empleado> buscarPorEspecialidad(String especialidad) {
        return empleados.stream()
                .filter(e -> e.getEspecialidad() != null &&
                        e.getEspecialidad().equalsIgnoreCase(especialidad))
                .toList();
    }
}