package com.examen.demo.exception;

public class ProveedorNotFoundException extends RuntimeException {

    public ProveedorNotFoundException(String mensaje) {
        super(mensaje);
    }
}