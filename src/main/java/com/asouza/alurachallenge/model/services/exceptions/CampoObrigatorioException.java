package com.asouza.alurachallenge.model.services.exceptions;

public class CampoObrigatorioException extends RuntimeException{
    public CampoObrigatorioException(String message) {
        super(message);
    }
}
