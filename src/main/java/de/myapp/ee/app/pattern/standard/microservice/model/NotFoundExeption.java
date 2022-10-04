package de.myapp.ee.app.pattern.standard.microservice.model;

import java.util.UUID;

public class NotFoundExeption extends RuntimeException{
    private static final UUID serialVersionUID = UUID.randomUUID();

    public NotFoundExeption(String message){
        super(message);
    }
}
