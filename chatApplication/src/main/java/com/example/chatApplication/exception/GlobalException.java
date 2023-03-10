package com.example.chatApplication.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(IndexOutOfBoundsException.class)
    public String indexOutOfBoundsException(IndexOutOfBoundsException ex){
        String message = ex.getMessage();
        return "IndexOutOfBoundsException - "+message;
    }
}
