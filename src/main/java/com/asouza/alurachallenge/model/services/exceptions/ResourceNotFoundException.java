package com.asouza.alurachallenge.model.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(Long id) {
        super("Entidade não encontrada. ID: "+ id);
    }
}
