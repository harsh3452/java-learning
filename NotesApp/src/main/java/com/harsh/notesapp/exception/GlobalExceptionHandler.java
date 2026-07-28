package com.harsh.notesapp.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, List<String>>> handleValidationException(MethodArgumentNotValidException exception){
        Map<String, List<String>> errors = new HashMap<>();
        List<FieldError> fieldErrors  = exception.getBindingResult().getFieldErrors();
        for(FieldError error : fieldErrors){
            String field = error.getField();
            String message = error.getDefaultMessage();
            if(!errors.containsKey(field)){
                errors.put(field,new ArrayList<>());
            }
            errors.get(field).add(message);
        }
        return ResponseEntity.badRequest().body(errors);
    }
}
