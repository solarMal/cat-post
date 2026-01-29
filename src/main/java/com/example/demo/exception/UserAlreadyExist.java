package com.example.demo.exception;

public class UserAlreadyExist extends RuntimeException {
    public UserAlreadyExist(String message) {
        super(message);
    }
}
