package com.example.demo.controller;

import com.example.demo.exception.PostNotFoundException;
import com.example.demo.exception.UserAlreadyExist;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.exception.ValidateException;
import com.example.demo.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice("com.example.demo")
public class ErrorHandler {

    @ExceptionHandler(ValidateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse validateException(ValidateException e) {
        return new ErrorResponse(e.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse userNotFoundException(UserNotFoundException e) {
        return new ErrorResponse(e.getMessage());
    }

    @ExceptionHandler(UserAlreadyExist.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse userAlreadyExist(UserAlreadyExist e) {
        return new ErrorResponse(e.getMessage());
    }

    @ExceptionHandler(PostNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse postNotFoundException(PostNotFoundException e) {
        return new ErrorResponse(e.getMessage());
    }
}
