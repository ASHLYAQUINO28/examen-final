package com.examen.demo.exception;

public class ProfesorNotFoundException extends RuntimeException {

    public ProfesorNotFoundException(String mensaje) {
        super(mensaje);
    }
}