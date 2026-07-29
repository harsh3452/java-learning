package com.harsh.notesapp.exception;

import com.harsh.notesapp.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.function.EntityResponse;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException exception){
        Map<String,List<String>> errors = new HashMap<>();
        List<FieldError> fieldErrors  = exception.getBindingResult().getFieldErrors(); //function to get field errors.
        //we are iterating over all fieldErrors to map them to have them in structured manner
        for(FieldError fieldError : fieldErrors){
           String field = fieldError.getField(); //gets the field name like title, body etc
           String message = fieldError.getDefaultMessage(); // gets the message such as title cannot be null etc
           errors.computeIfAbsent(field,k->new ArrayList<>()); // this is if the key/field is not present add a key and a list of string with it so we an add message later
            errors.get(field).add(message);
        }
        ErrorResponse errorResponse = new com.harsh.notesapp.dto.ErrorResponse(); // creating a custom error format for consistency across errors
        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setErrors(errors);
        errorResponse.setMessage("Validation Failed");
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value()); // extracting the value of the status code and assigning
        return ResponseEntity.badRequest().body(errorResponse);
    }
    @ExceptionHandler(NoteNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoteNotFoundException(NoteNotFoundException exception){
        Map<String,List<String>> errors = new HashMap<>();
        String message = exception.getMessage();
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(message);
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setErrors(errors);
        errorResponse.setTimestamp(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}
