package com.examen.demo.exception;

public class EmpleadoNotFoundException extends RuntimeException {

    public EmpleadoNotFoundException(String mensaje) {
        super(mensaje);
    }
}