package com.geekster.hibernateMapping.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public void methodArgumentNotValidException(MethodArgumentNotValidException ex){
        String message = ex.getMessage();
        System.out.println("MethodArgumentNotValidException : "+message);
    }

    @ExceptionHandler(RecordNotFound.class)
    public String recordNotFound(RecordNotFound ex){
        String message = ex.getMessage();
        System.out.println(message);
        return message;
    }
}
