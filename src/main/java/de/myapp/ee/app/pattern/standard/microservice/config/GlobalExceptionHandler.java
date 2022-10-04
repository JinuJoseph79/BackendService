package de.myapp.ee.app.pattern.standard.microservice.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import de.myapp.ee.app.pattern.standard.microservice.model.AlreadyExistsException;
import de.myapp.ee.app.pattern.standard.microservice.model.NotFoundExeption;

import javax.naming.NotContextException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {NotFoundExeption.class})
    public ResponseEntity<Object> handleNotFoundExeption(NotFoundExeption e){
        HttpStatus notFound = HttpStatus.NOT_FOUND;
        Map<String, Object> message = new HashMap<>();

        message.put("message", e.getMessage());
        message.put("status", notFound);
        message.put("code", notFound.value());
        message.put("timestamp", ZonedDateTime.now(ZoneId.of("Z")));

        return new ResponseEntity<>(message, notFound);
    }

    @ExceptionHandler(value = {AlreadyExistsException.class})
    public ResponseEntity<Object> handleAlreadyExistsException(AlreadyExistsException e){
        HttpStatus badRequest = HttpStatus.CONFLICT;
        Map<String, Object> message = new HashMap<>();

        message.put("message", e.getMessage());
        message.put("status", badRequest);
        message.put("code", badRequest.value());
        message.put("timestamp", ZonedDateTime.now(ZoneId.of("Z")));

        return new ResponseEntity<>(message, badRequest);
    }
}
