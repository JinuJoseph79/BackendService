package de.myapp.ee.app.pattern.standard.microservice.model;

import java.util.UUID;

public class AlreadyExistsException extends RuntimeException {
    private static final UUID serialVersionUID = UUID.randomUUID();

    public AlreadyExistsException(String message){
        super(message);
    }
}
