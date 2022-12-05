package org.soulcodeacademy.empresa.services.errors;

public class RecursoNaoEncontradoError extends RuntimeException {

    public RecursoNaoEncontradoError(String message) {
        super(message);
    }

}
